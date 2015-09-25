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
import java.net.FileNameMap;
import java.net.URLConnection;

import eu.medsea.mimeutil.MimeUtil2;

/**
 * The Enum Mimetypes.
 */
public enum Mimetypes
{

	/** The image jpeg. */
	IMAGE_JPEG("image/jpeg"),

	/** The image pjpeg. */
	IMAGE_PJPEG("image/pjpeg"),

	/** The image png. */
	IMAGE_PNG("image/png"),

	/** The image gif. */
	IMAGE_GIF("image/gif"),

	/** The image tiff. */
	IMAGE_TIFF("image/tiff"),

	/** The image ief. */
	IMAGE_IEF("image/ief"),

	/** The image x icon. */
	IMAGE_X_ICON("image/x-icon"),

	/** The image x xcf.GIMP image file */
	IMAGE_X_XCF("image/x-xcf"),

	/** The text csv. */
	TEXT_CSV("text/csv"),

	/** The eml. */
	EML("message/rfc822"),

	/** The text ics. */
	TEXT_ICS("text/calendar"),

	/** The text plain. */
	TEXT_PLAIN("text/plain"),

	/** The text html. */
	TEXT_HTML("text/html"),

	/** The text xml. */
	TEXT_XML("text/xml"),

	/** The application pdf. */
	APPLICATION_PDF("application/pdf"),

	/** The application rtf. */
	APPLICATION_RTF("application/rtf"),

	/** The application octet. */
	APPLICATION_OCTET("application/octet-stream");

	/**
	 * Gets the mime type from the given File. It make use of the library mime-util
	 * 'http://sourceforge.net/projects/mime-util/'.
	 *
	 * @param file
	 *            the file
	 * @return the mime type
	 */
	public static String getExtension(final File file)
	{
		String extension;
		final MimeUtil2 mimeUtil = new MimeUtil2();
		mimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
		extension = MimeUtil2.getExtension(file);
		return extension;
	}

	/**
	 * Gets the mime type from the given File. It make use of the library mime-util
	 * 'http://sourceforge.net/projects/mime-util/'.
	 *
	 * @param fileName
	 *            the file name
	 * @return the extension
	 */
	public static String getExtension(final String fileName)
	{
		String extension;
		final MimeUtil2 mimeUtil = new MimeUtil2();
		mimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
		extension = MimeUtil2.getExtension(fileName);
		return extension;
	}

	/**
	 * Gets the mime type from the given File. It make use of the library mime-util
	 * 'http://sourceforge.net/projects/mime-util/'.
	 *
	 * @param file
	 *            the file
	 * @return the mime type
	 */
	public static String getMimeType(final File file)
	{
		final FileNameMap fileNameMap = URLConnection.getFileNameMap();
		String mimeType = fileNameMap.getContentTypeFor(file.getName());
		if (mimeType == null)
		{
			final MimeUtil2 mimeUtil = new MimeUtil2();
			mimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
			mimeType = MimeUtil2.getMostSpecificMimeType(mimeUtil.getMimeTypes(file)).toString();
		}
		return mimeType;
	}

	/** The mimetype. */
	private final String mimetype;

	/**
	 * Instantiates a new mimetypes.
	 *
	 * @param mimetype
	 *            the mimetype
	 */
	private Mimetypes(final String mimetype)
	{
		this.mimetype = mimetype;
	}

	/**
	 * Gets the mimetype.
	 *
	 * @return the mimetype
	 */
	public String getMimetype()
	{
		return mimetype;
	}
}
