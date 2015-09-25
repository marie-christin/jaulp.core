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
package de.alpharogroup.date;

/**
 * Interface for Date-Patterns.
 *
 * @version 1.0
 * @author Asterios Raptis
 */
public interface DatePatterns
{

	/**
	 * Dateformat in String. Current value:"yyyy-MM-dd'T'HH:mm:ss"
	 */
	public String YYYY_MM_DD_T_HH_MM_SS = "yyyy-MM-dd'T'HH:mm:ss";

	/**
	 * Dateformat in String. Current value:"EEEE MMM dd, yyyy"
	 */
	public String EEEE_MMM_DD_YYYY = "EEEE MMM dd, yyyy";

	/**
	 * Dateformat in String. Current value:"dd-MMM-yy"
	 */
	public String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd hh:mm:ss";

	/**
	 * Dateformat in String. Current value:"dd-MMM-yy"
	 */
	public String DD_MMM_YY = "dd-MMM-yy";

	/**
	 * Dateformat in String. Current value:"yyyy.MM.dd.HH.mm.ss"
	 */
	public String DOT_YYYY_MM_DD_HH_MM_SS = "yyyy.MM.dd.HH.mm.ss";

	/**
	 * Dateformat in String. Current value:"EEE MMM dd hh:mm:ss z yyyy"
	 */
	public String EEE_MMM_DD_HH_MM_SS_Z_YYYY = "EEE MMM dd hh:mm:ss z yyyy";

	/**
	 * Dateformat in String. Current value:"yyyy-MM-dd hh:mm:ss.S"
	 */
	public String YYYY_MM_DD_HH_MM_SS_S = "yyyy-MM-dd hh:mm:ss.S";

	/**
	 * Dateformat in String. Current value:"dd.MM"
	 */
	public String DOT_DD_MM = "dd.MM";

	/**
	 * Dateformat in String. Current value:"yyyyMMddHHmmss"
	 */
	public String YYYYMMDDHHMMSS = "yyyyMMddHHmmss";

	/**
	 * Dateformat in String. Current value:"HH:mm:ss"
	 */
	public String UHH_MM_SS = "HH:mm:ss";

	/**
	 * Dateformat in String. Current value:"HH:mm:ss"
	 */
	public String UHH_MM = "HH:mm";

	/**
	 * Dateformat in String. Current value:"hh:mm:ss"
	 */
	public String LHH_MM_SS = "hh:mm:ss";

	/**
	 * Dateformat in String. Current value:"dd.MM.yyyy"
	 */
	public String DOT_DD_MM_YYYY = "dd.MM.yyyy";

	/**
	 * Dateformat in String. Current value:"dd.MM.yyyy HH:mm:ss"
	 */
	public String DOT_DD_MM_YYYY_HH_MM_SS = DOT_DD_MM_YYYY + " " + UHH_MM_SS;

	/**
	 * Dateformat in String. Current value:"yyyy-MM-dd"
	 */
	public String YYYY_MM_DD = "yyyy-MM-dd";

	/**
	 * Dateformat in String. Current value:"dd.MM.yy"
	 */
	public String DOT_DD_MM_YY = "dd.MM.yy";

}