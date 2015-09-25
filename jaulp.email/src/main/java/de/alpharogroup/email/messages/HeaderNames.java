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

/**
 * The Enum HeaderNames contains some header names that are added in the header of an email.
 */
public enum HeaderNames
{

	/** The header name 'Return-Path'. */
	RETURN_PATH("Return-Path"),

	/** The header name 'Received'. */
	RECEIVED("Received"),

	/** The header name 'Resent-Date'. */
	RESENT_DATE("Resent-Date"),

	/** The header name 'Resent-From'. */
	RESENT_FROM("Resent-From"),

	/** The header name 'Resent-Sender'. */
	RESENT_SENDER("Resent-Sender"),

	/** The header name 'Resent-To'. */
	RESENT_TO("Resent-To"),

	/** The header name 'Resent-Cc'. */
	RESENT_CC("Resent-Cc"),

	/** The header name 'Resent-Bcc'. */
	RESENT_BCC("Resent-Bcc"),

	/** The header name 'Resent-Message-Id'. */
	RESENT_MESSAGE_ID("Resent-Message-Id"),

	/** The header name 'Date'. */
	DATE("Date"),

	/** The header name 'From'. */
	FROM("From"),

	/** The header name 'Sender'. */
	SENDER("Sender"),

	/** The header name 'Reply-To'. */
	REPLY_TO("Reply-To"),

	/** The header name 'To'. */
	TO("To"),

	/** The header name 'Cc'. */
	CC("Cc"),

	/** The header name 'Bcc'. */
	BCC("Bcc"),

	/** The header name 'Message-Id'. */
	MESSAGE_ID("Message-Id"),

	/** The header name 'In-Reply-To'. */
	IN_REPLY_TO("In-Reply-To"),

	/** The header name 'References'. */
	REFERENCES("References"),

	/** The header name 'Subject'. */
	SUBJECT("Subject"),

	/** The header name 'Comments'. */
	COMMENTS("Comments"),

	/** The header name 'Keywords'. */
	KEYWORDS("Keywords"),

	/** The header name 'Errors-To'. */
	ERRORS_TO("Errors-To"),

	/** The header name 'MIME-Version'. */
	MIME_VERSION("MIME-Version"),

	/** The header name 'Content-Type'. */
	CONTENT_TYPE("Content-Type"),

	/** The header name 'Content-Transfer-Encoding'. */
	CONTENT_TRANSFER_ENCODING("Content-Transfer-Encoding"),

	/** The header name 'Content-MD5'. */
	CONTENT_MD5("Content-MD5"),

	/** The header name ':'. */
	COLON(":"),

	/** The header name ''. */
	CONTENT_LENGTH("Content-Length"),

	/** The header name 'Status'. */
	STATUS("Status");

	/** The header name. */
	private final String headerName;

	/**
	 * The Constructor.
	 *
	 * @param headerName
	 *            the header name
	 */
	private HeaderNames(final String headerName)
	{
		this.headerName = headerName;
	}

	/**
	 * Gets the header name.
	 *
	 * @return the header name
	 */
	public String getHeaderName()
	{
		return headerName;
	}
}
