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
package de.alpharogroup.email.messages;

import java.io.IOException;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import lombok.Getter;
import de.alpharogroup.email.utils.EmailExtensions;

/**
 * This class represents an email message.
 */
public class EmailMessage extends MimeMessage implements Serializable
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The charset.
	 */
	@Getter
	private String charset;

	/**
	 * Default constructor. The Session is set to null.
	 */
	public EmailMessage()
	{
		this(null);
	}

	/**
	 * Constructor with a Session.
	 *
	 * @param session
	 *            the session
	 */
	public EmailMessage(final Session session)
	{
		super(session);
	}

	/**
	 * Adding one bcc-address to the EmailMessage.
	 *
	 * @param internetAddress
	 *            The InternetAddress-object.
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addBcc(final Address internetAddress) throws MessagingException
	{
		super.addRecipient(javax.mail.Message.RecipientType.BCC, internetAddress);
	}

	/**
	 * Adding one cc-address to the EmailMessage.
	 *
	 * @param internetAddress
	 *            The InternetAddress-object.
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addCc(final Address internetAddress) throws MessagingException
	{
		super.addRecipient(javax.mail.Message.RecipientType.CC, internetAddress);
	}

	/**
	 * Adding one from-address to the EmailMessage.
	 *
	 * @param internetAddress
	 *            The InternetAddress-object.
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addFrom(final Address internetAddress) throws MessagingException
	{
		super.addFrom(EmailExtensions.getAddressArray(internetAddress));
	}

	/**
	 * Adding one to-address to the EmailMessage.
	 *
	 * @param internetAddress
	 *            The InternetAddress-object.
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addTo(final Address internetAddress) throws MessagingException
	{
		super.addRecipient(javax.mail.Message.RecipientType.TO, internetAddress);
	}

	/**
	 * Clone.
	 *
	 * @return the object
	 * @throws CloneNotSupportedException
	 *             the clone not supported exception {@inheritDoc}
	 * @see java.lang.Object#clone()
	 */
	@Override
	protected Object clone() throws CloneNotSupportedException
	{
		final EmailMessage cloned = new EmailMessage();
		try
		{
			cloned.setExpunged(expunged);
			cloned.setMessageNumber(this.getMessageNumber());
			cloned.setContent(this.getContent(), this.getContentType());
			if (this.getContentID() != null)
			{
				cloned.setContentID(this.getContentID());
			}
			if (this.getContentLanguage() != null)
			{
				cloned.setContentLanguage(this.getContentLanguage());
			}
			if (this.getContentMD5() != null)
			{
				cloned.setContentMD5(this.getContentMD5());
			}
			if (this.getDataHandler() != null)
			{
				cloned.setDataHandler(this.getDataHandler());
			}

			if (this.getFileName() != null)
			{
				cloned.setFileName(this.getFileName());
			}
			if (this.getFlags() != null)
			{
				cloned.setFlags(this.getFlags(), true);
			}
			if (this.getFrom() != null)
			{
				final Address[] fromAddresses = this.getFrom();
				for (final Address fromAddresse : fromAddresses)
				{
					cloned.setFrom(fromAddresse);
				}
			}
			@SuppressWarnings("rawtypes")
			final Enumeration enumeration = this.getAllHeaderLines();
			while (enumeration.hasMoreElements())
			{
				final String line = (String)enumeration.nextElement();
				cloned.addHeaderLine(line);
			}
			if (this.getRecipients(javax.mail.Message.RecipientType.TO) != null)
			{
				final Address[] toAddresses = this
					.getRecipients(javax.mail.Message.RecipientType.TO);
				cloned.setRecipients(javax.mail.Message.RecipientType.TO, toAddresses);
			}
			if (this.getRecipients(javax.mail.Message.RecipientType.CC) != null)
			{
				final Address[] ccAddresses = this
					.getRecipients(javax.mail.Message.RecipientType.CC);
				cloned.setRecipients(javax.mail.Message.RecipientType.CC, ccAddresses);
			}
			if (this.getRecipients(javax.mail.Message.RecipientType.BCC) != null)
			{
				final Address[] bccAddresses = this
					.getRecipients(javax.mail.Message.RecipientType.BCC);
				cloned.setRecipients(javax.mail.Message.RecipientType.BCC, bccAddresses);
			}
			if (this.getReplyTo() != null)
			{
				final Address[] replyToAddresses = this.getReplyTo();
				cloned.setReplyTo(replyToAddresses);
			}
			if (this.getSender() != null)
			{
				cloned.setSender(this.getSender());
			}
			if (this.getSentDate() != null)
			{
				cloned.setSentDate(this.getSentDate());
			}
			if (this.getCharset() != null)
			{
				if (this.getSubject() != null)
				{
					cloned.setSubject(this.getSubject(), this.getCharset());
				}
				if (this.getDescription() != null)
				{
					cloned.setDescription(this.getDescription(), this.getCharset());
				}
			}
			else
			{
				if (this.getSubject() != null)
				{
					cloned.setSubject(this.getSubject());
				}
				if (this.getDescription() != null)
				{
					cloned.setDescription(this.getDescription());
				}
			}
		}
		catch (final MessagingException e)
		{
			e.printStackTrace();
		}
		catch (final IOException e)
		{
			e.printStackTrace();
		}
		return super.clone();
	}

	@Override
	public boolean equals(final Object obj)
	{
		if (this == obj)
		{
			return true;
		}
		if (obj == null)
		{
			return false;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		final EmailMessage other = (EmailMessage)obj;
		if (charset == null)
		{
			if (other.charset != null)
			{
				return false;
			}
		}
		else if (!charset.equals(other.charset))
		{
			return false;
		}
		return true;
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + (charset == null ? 0 : charset.hashCode());
		return result;
	}

	/**
	 * Sets the content.
	 *
	 * @param content
	 *            the content
	 * @param type
	 *            the type
	 * @throws MessagingException
	 *             the messaging exception
	 *
	 * @see javax.mail.Part#setContent(java.lang.Object, java.lang.String)
	 */
	@Override
	public void setContent(final Object content, final String type) throws MessagingException
	{
		charset = EmailExtensions.getCharsetFromContentType(type);
		super.setContent(content, type);
	}

	/**
	 * Sets the from address.
	 *
	 * @param senderEmail
	 *            the new from
	 * @throws AddressException
	 *             the address exception
	 * @throws UnsupportedEncodingException
	 *             the unsupported encoding exception
	 * @throws MessagingException
	 *             the messaging exception
	 */
	public void setFrom(final String senderEmail) throws AddressException,
		UnsupportedEncodingException, MessagingException
	{
		final Address fromEmail = EmailExtensions.newAddress(senderEmail);
		super.setFrom(fromEmail);
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject
	 *            the new subject
	 * @throws MessagingException
	 *             the messaging exception
	 *
	 * @see javax.mail.Message#setSubject(java.lang.String)
	 */
	@Override
	public void setSubject(final String subject) throws MessagingException
	{
		if (charset == null)
		{
			super.setSubject(subject);
			return;
		}
		setSubject(subject, charset);
	}

	/**
	 * Sets the subject.
	 *
	 * @param subject
	 *            the subject
	 * @param charset
	 *            the charset
	 * @throws MessagingException
	 *             the messaging exception
	 *
	 * @see javax.mail.internet.MimeMessage#setSubject(java.lang.String, java.lang.String)
	 */
	@Override
	public void setSubject(final String subject, final String charset) throws MessagingException
	{
		super.setSubject(subject, charset);
	}

	/**
	 * Sets the utf8 content.
	 *
	 * @param content
	 *            the new utf8 content
	 * @throws MessagingException
	 *             the messaging exception
	 *
	 * @see javax.mail.Part#setContent(java.lang.Object, java.lang.String)
	 */
	public void setUtf8Content(final Object content) throws MessagingException
	{
		final String type = EmailConstants.MIMETYPE_TEXT_PLAIN + EmailConstants.CHARSET_PREFIX
			+ EmailConstants.CHARSET_UTF8;
		setContent(content, type);
	}

}
