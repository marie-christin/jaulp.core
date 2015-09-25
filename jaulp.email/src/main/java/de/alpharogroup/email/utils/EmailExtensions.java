/**
 * The MIT License
 *
 * Copyright (C) 2007 Asterios Raptis
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the
 * "Software"), to deal in the Software without restriction, including
 * without limitation the rights to use, copy, modify, merge, publish,
 * distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to
 * the following conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE
 * LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION
 * OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION
 * WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package de.alpharogroup.email.utils;

import java.io.UnsupportedEncodingException;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import lombok.experimental.ExtensionMethod;

import org.apache.log4j.Logger;

import de.alpharogroup.email.messages.EmailConstants;
import de.alpharogroup.email.messages.EmailMessage;
import de.alpharogroup.string.StringExtensions;

/**
 * The Class EmailExtensions provides methods for create email addresses and validate email
 * addresses.
 */
@ExtensionMethod(StringExtensions.class)
public class EmailExtensions
{

	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(EmailExtensions.class.getName());

	/**
	 * Adds a 'to' recipient to the email message.
	 *
	 * @param recipientEmail
	 *            the recipient email
	 * @param recipientPersonal
	 *            the recipient personal
	 * @param recipientCharset
	 *            the recipient charset
	 * @param emailMessage
	 *            the email message
	 * @return the email message
	 */
	public static EmailMessage addToRecipientToEmailMessage(final String recipientEmail,
		final String recipientPersonal, final String recipientCharset,
		final EmailMessage emailMessage)
	{

		// Try to create the recipient Address
		Address recipientAddress = null;
		try
		{
			recipientAddress = EmailExtensions.newAddress(recipientEmail, recipientPersonal,
				recipientCharset);

		}
		catch (final AddressException e2)
		{
			logger.error("AddressException when tryin to create the recipient Address:"
				+ recipientEmail, e2);
			e2.printStackTrace();
		}
		catch (final UnsupportedEncodingException e2)
		{
			logger.error("UnsupportedEncodingException when tryin to create the recipient Address:"
				+ recipientEmail, e2);
			e2.printStackTrace();
		}

		// Set recipient
		if (null != recipientAddress)
		{
			try
			{
				emailMessage.addTo(recipientAddress);
			}
			catch (final MessagingException e)
			{
				try
				{
					emailMessage.setRecipients(Message.RecipientType.TO, recipientEmail);
				}
				catch (final AddressException e1)
				{
					logger.error("AddressException when tryin to set the To Address:"
						+ recipientEmail, e1);
					e1.printStackTrace();
				}
				catch (final MessagingException e1)
				{
					logger.error("MessagingException when tryin to set the To Address:"
						+ recipientEmail, e1);
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				emailMessage.setRecipients(Message.RecipientType.TO, recipientEmail);
			}
			catch (final AddressException e1)
			{
				logger.error("AddressException when tryin to set the To Address:" + recipientEmail,
					e1);
				e1.printStackTrace();
			}
			catch (final MessagingException e1)
			{
				logger.error("MessagingException when tryin to set the To Address:"
					+ recipientEmail, e1);
				e1.printStackTrace();
			}
		}
		return emailMessage;
	}

	/**
	 * Gets the address array from the given address objects.
	 *
	 * @param address
	 *            the address
	 * @return the address array
	 */
	public static Address[] getAddressArray(final Address... address)
	{
		return address;
	}

	/**
	 * Gets the encoding from the header.
	 *
	 * @param type
	 *            The string where the encoding is in.
	 *
	 * @return 's the encoding or null if its nothing found.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public static String getCharsetFromContentType(final String type) throws MessagingException
	{
		if (!type.isNullOrEmpty())
		{
			int start = type.indexOf(EmailConstants.CHARSET_PREFIX);
			if (start > 0)
			{
				start += EmailConstants.CHARSET_PREFIX.length();
				final int offset = type.indexOf(" ", start);
				if (offset > 0)
				{
					return type.substring(start, offset);
				}
				else
				{
					return type.substring(start);
				}
			}
		}
		return null;
	}

	/**
	 * Creates an Address from the given the email address as String object.
	 *
	 * @param address
	 *            The address in RFC822 format.
	 *
	 * @return The created InternetAddress-object from the given address.
	 *
	 * @throws AddressException
	 *             if an error occurs.
	 * @throws UnsupportedEncodingException
	 *             if an error occurs.
	 */
	public static Address newAddress(final String address) throws AddressException,
		UnsupportedEncodingException
	{
		return newAddress(address, null, null);
	}

	/**
	 * Creates from the given the address and personal name an Adress-object.
	 *
	 * @param emailAddress
	 *            The address in RFC822 format.
	 * @param personal
	 *            The personal name.
	 *
	 * @return The created Adress-object from the given address and personal name.
	 *
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 * @throws AddressException
	 *             the address exception
	 */
	public static Address newAddress(final String emailAddress, final String personal)
		throws AddressException, UnsupportedEncodingException
	{
		return newAddress(emailAddress, personal, null);
	}

	/**
	 * Creates an Address from the given the address and personal name.
	 *
	 * @param address
	 *            The address in RFC822 format.
	 * @param personal
	 *            The personal name.
	 * @param charset
	 *            MIME charset to be used to encode the name as per RFC 2047.
	 *
	 * @return The created InternetAddress-object from the given address and personal name.
	 *
	 * @throws AddressException
	 *             if an error occurs.
	 * @throws UnsupportedEncodingException
	 *             if an error occurs.
	 */
	public static Address newAddress(final String address, String personal, final String charset)
		throws AddressException, UnsupportedEncodingException
	{
		if (personal.isNullOrEmpty())
		{
			personal = address;
		}
		final InternetAddress internetAdress = new InternetAddress(address);
		if (charset.isNullOrEmpty())
		{
			internetAdress.setPersonal(personal);
		}
		else
		{
			internetAdress.setPersonal(personal, charset);
		}
		return internetAdress;
	}

	/**
	 * Sets the from to the email message.
	 *
	 * @param senderEmail
	 *            the sender email
	 * @param senderPersonal
	 *            the sender personal
	 * @param senderCharset
	 *            the sender charset
	 * @param emailMessage
	 *            the email message
	 * @return the email message
	 */
	public static EmailMessage setFromToEmailMessage(final String senderEmail,
		final String senderPersonal, final String senderCharset, final EmailMessage emailMessage)
	{
		// Try to create the sender Address
		Address senderAddress = null;
		try
		{
			senderAddress = EmailExtensions.newAddress(senderEmail, senderPersonal, senderCharset);

		}
		catch (final AddressException e2)
		{
			logger.error("AddressException when tryin to create the sender Address:" + senderEmail,
				e2);
			e2.printStackTrace();
		}
		catch (final UnsupportedEncodingException e2)
		{
			logger.error("UnsupportedEncodingException when tryin to create the sender Address:"
				+ senderEmail, e2);
			e2.printStackTrace();
		}
		// Set sender
		if (null != senderAddress)
		{
			try
			{
				emailMessage.setFrom(senderAddress);
			}
			catch (final MessagingException e)
			{
				try
				{
					emailMessage.setFrom(senderEmail);
				}
				catch (final AddressException e1)
				{
					logger.error("AddressException when tryin to set the From Address:"
						+ senderEmail, e1);
					e1.printStackTrace();
				}
				catch (final UnsupportedEncodingException e1)
				{
					logger.error("UnsupportedEncodingException when tryin to set the From Address:"
						+ senderEmail, e1);
					e1.printStackTrace();
				}
				catch (final MessagingException e1)
				{
					logger.error("MessagingException when tryin to set the From Address:"
						+ senderEmail, e1);
					e1.printStackTrace();
				}
				e.printStackTrace();
			}
		}
		else
		{
			try
			{
				emailMessage.setFrom(senderEmail);
			}
			catch (final AddressException e1)
			{
				logger.error("AddressException when tryin to set the From Address:" + senderEmail,
					e1);
				e1.printStackTrace();
			}
			catch (final UnsupportedEncodingException e1)
			{
				logger.error("UnsupportedEncodingException when tryin to set the From Address:"
					+ senderEmail, e1);
				e1.printStackTrace();
			}
			catch (final MessagingException e1)
			{
				logger.error(
					"MessagingException when tryin to set the From Address:" + senderEmail, e1);
				e1.printStackTrace();
			}
		}
		return emailMessage;
	}


	/**
	 * Validate the given email address.
	 *
	 * @param emailAddress
	 *            the email address
	 *
	 * @return true, if successful
	 */
	public static boolean validateEmailAdress(final String emailAddress)
	{
		boolean isValid = true;
		try
		{
			final InternetAddress internetAddress = new InternetAddress(emailAddress);
			internetAddress.validate();
		}
		catch (final AddressException e)
		{
			isValid = false;
		}
		return isValid;
	}
}
