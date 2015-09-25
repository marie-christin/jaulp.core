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
package de.alpharogroup.email;

import static org.testng.AssertJUnit.assertFalse;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import lombok.experimental.ExtensionMethod;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import de.alpharogroup.email.messages.EmailConstants;
import de.alpharogroup.email.messages.EmailMessage;
import de.alpharogroup.email.messages.EmailMessageWithAttachments;
import de.alpharogroup.email.send.SendEmail;
import de.alpharogroup.email.send.SendMail;
import de.alpharogroup.email.utils.EmailExtensions;
import de.alpharogroup.lang.ClassExtensions;
import de.alpharogroup.lang.PackageUtils;
import de.alpharogroup.string.StringExtensions;

@ExtensionMethod(StringExtensions.class)
public class SendEmailTest
{

	private Properties emailProperties = null;

	@BeforeMethod
	public void setUp() throws Exception
	{
		// emailProperties = new Properties();
		// emailProperties.put( "mail.smtp.host", "localhost" );
	}

	@AfterMethod
	public void tearDown() throws Exception
	{
		emailProperties = null;
	}

	@Test(enabled = false)
	public void testSendEmailEmailAttachments_01() throws AddressException,
		UnsupportedEncodingException, MessagingException
	{
		final EmailMessage message = new EmailMessage();
		final SendMail sender = new SendEmail();
		final Address from = EmailExtensions.newAddress("asterios.raptis@gmx.net", null);
		message.addFrom(EmailExtensions.getAddressArray(from));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@yahoo.gr", "Asterios Raptis", null));
		message.setSubject("Text/plain Attachments");

		message.setText("This is the text from the email.");
		final MimeMultipart content = new MimeMultipart();
		message.setContent(content);

		final BodyPart part = new MimeBodyPart();
		part.setFileName("text.txt");
		part.setDescription("One textfile");
		part.setDisposition(javax.mail.Part.ATTACHMENT);
		part.setText("This is an email with unicode characters. ÄÖÜ_äöüß.");

		content.addBodyPart(part);
		final String messageId = sender.sendEmailMessage(message);
		System.out.println("messageId:" + messageId);
	}

	@Test(enabled = false)
	public void testSendEmailEmailAttachments_02() throws AddressException,
		UnsupportedEncodingException, MessagingException, URISyntaxException
	{
		final SendMail sender = new SendEmail();

		final EmailMessage message = new EmailMessage();
		final Address from = EmailExtensions.newAddress("asterios.raptis@gmx.net", null);
		message.addFrom(EmailExtensions.getAddressArray(from));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@yahoo.gr", "Asterios Raptis", null));
		message.setSubject("mailerWithNewMethods.GIF");
		final EmailMessageWithAttachments mailer = new EmailMessageWithAttachments(message);

		final BodyPart main = new MimeBodyPart();
		main.setText("This is an email with unicode characters. ÄÖÜ_äöüß. _1");

		mailer.addAttachment(main);

		final BodyPart gif = new MimeBodyPart();
		gif.setFileName("green.gif");
		final String path = PackageUtils.getPackagePathWithSlash(this);
		final String filePath = path + "test.gif";
		System.out.println("filePath:" + filePath);
		final File giffile = ClassExtensions.getResourceAsFile(filePath, this);

		mailer.addAttachment(giffile);

		final String messageId = sender.sendEmailMessage(message);
		System.out.println("messageId:" + messageId);
	}

	@Test(enabled = false)
	public void testSendEmailEmailMessage() throws AddressException, UnsupportedEncodingException,
		MessagingException
	{
		final SendMail sender = new SendEmail(emailProperties);
		final EmailMessage message = new EmailMessage();
		final Address from = EmailExtensions.newAddress("asterios.raptis@gmx.net", "Asterios Raptis");
		message.addFrom(EmailExtensions.getAddressArray(from));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@yahoo.gr", "Asterios Raptis",
			EmailConstants.CHARSET_UTF8));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@web.de", "Asterios Raptis",
			EmailConstants.CHARSET_UTF8));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@gmx.net", "Asterios Raptis",
			EmailConstants.CHARSET_UTF8));
		message.setSubject("Simple email with unicod characters. ÄÖÜ_äöüß.", "UTF-8");
		message.setContent("This is a simple email send with SendEmail. ÄÖÜ_äöüß.",
			EmailConstants.MIMETYPE_TEXT_PLAIN + "; charset=UTF-8");
		final String messageId = sender.sendEmailMessage(message);
		System.out.println("messageId:" + messageId);
		assertFalse(messageId.isNullOrEmpty());
	}

	@Test(enabled = false)
	public void testSendEmailStringStringStringString() throws AddressException,
		UnsupportedEncodingException, MessagingException
	{
		final SendMail sender = new SendEmail(emailProperties);
		final EmailMessage message = new EmailMessage();
		final Address from = EmailExtensions.newAddress("asterios.raptis@gmx.net", "Asterios Raptis");
		message.addFrom(EmailExtensions.getAddressArray(from));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@yahoo.gr", "Asterios Raptis",
			EmailConstants.CHARSET_UTF8));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@web.de", "Asterios Raptis",
			EmailConstants.CHARSET_UTF8));
		message.addTo(EmailExtensions.newAddress("asterios.raptis@gmx.net", "Asterios Raptis",
			EmailConstants.CHARSET_UTF8));
		final String messageId = sender.sendEmail("asterios.raptis@yahoo.gr",
			"asterios.raptis@gmx.net", "Test method testSendEmailStringStringStringString().",
			"This is a simple email send with SendEmail. ÄÖÜ_äöüß.");
		System.out.println("messageId:" + messageId);
		assertFalse(messageId.isNullOrEmpty());
	}

}
