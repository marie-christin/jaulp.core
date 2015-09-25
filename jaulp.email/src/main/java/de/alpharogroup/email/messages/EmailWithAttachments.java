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

import java.io.File;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.MessagingException;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMultipart;

import de.alpharogroup.email.data.sources.ByteArrayDataSource;

/**
 * This class adds the functionality to add attachments to the EmailMessage.
 *
 * @author Asterios Raptis
 */
public class EmailWithAttachments extends EmailMessage
{

	/**
	 * The serialVersionUID.
	 */
	private static final long serialVersionUID = 1L;

	/** The MimeMultipart for the attachments. */
	private final MimeMultipart mimeMultiPart;

	/**
	 * Constructor for the EmailAttachments.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public EmailWithAttachments() throws MessagingException
	{
		mimeMultiPart = new MimeMultipart();
		setContent(mimeMultiPart);
	}

	/**
	 * Adds an attachment to the EmailMessage.
	 *
	 * @param part
	 *            The BodyPart to add to the EmailMessage.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addAttachment(final BodyPart part) throws MessagingException
	{
		getMimeMultiPart().addBodyPart(part);
	}

	/**
	 * Adds the attachment.
	 *
	 * @param content
	 *            The bytearray with the content.
	 * @param filename
	 *            The new Filename for the attachment.
	 * @param mimetype
	 *            The mimetype.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addAttachment(final byte[] content, final String filename, final String mimetype)
		throws MessagingException
	{
		final DataSource dataSource = new ByteArrayDataSource(content, mimetype);
		final DataHandler dataHandler = new DataHandler(dataSource);
		addAttachment(dataHandler, filename);
	}

	/**
	 * Adds the attachment.
	 *
	 * @param handler
	 *            The DataHandler for the attachment.
	 * @param filename
	 *            The new Filename for the attachment.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addAttachment(final DataHandler handler, final String filename)
		throws MessagingException
	{
		final BodyPart part = new MimeBodyPart();
		part.setFileName(filename);
		part.setDataHandler(handler);
		addAttachment(part);
	}

	/**
	 * Adds an attachment to the EmailMessage.
	 *
	 * @param file
	 *            The file to add to the EmailMessage.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addAttachment(final File file) throws MessagingException
	{
		DataSource dataSource;
		dataSource = new FileDataSource(file);
		final DataHandler dataHandler = new DataHandler(dataSource);
		addAttachment(dataHandler, file.getName());
	}

	/**
	 * Adds an attachment to the EmailMessage.
	 *
	 * @param file
	 *            The file to add to the EmailMessage.
	 * @param newFilename
	 *            The new Filename for the attachment.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public void addAttachment(final File file, final String newFilename) throws MessagingException
	{
		DataSource dataSource;
		dataSource = new FileDataSource(file);
		final DataHandler dataHandler = new DataHandler(dataSource);
		addAttachment(dataHandler, newFilename);
	}

	/**
	 * Gets the MimeMultipart from the EmailAttachments.
	 *
	 * @return 's the MimeMultipart from the EmailAttachments.
	 *
	 * @throws MessagingException
	 *             if an error occurs.
	 */
	public synchronized MimeMultipart getMimeMultiPart() throws MessagingException
	{
		return mimeMultiPart;
	}

}
