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
package de.alpharogroup.email.properties;

/**
 * The Class MailPropertiesConst.
 */
public abstract class MailPropertiesConst
{
	// GLOBAL start
	// user
	/** The Constant USER. */
	protected static final String USER = "user";

	// password
	/** The Constant PASSWORD. */
	protected static final String PASSWORD = "password";

	// store
	/** The Constant STORE. */
	protected static final String STORE = "store";

	// transport
	/** The Constant TRANSPORT. */
	protected static final String TRANSPORT = "transport";

	// port
	/** The Constant PORT. */
	protected static final String PORT = "port";

	// protocol
	/** The Constant PROTOCOL. */
	protected static final String PROTOCOL = "protocol";

	// .
	/** The Constant DOT. */
	protected static final String DOT = ".";

	// mail
	/** The Constant MAIL. */
	protected static final String MAIL = "mail";

	// host
	/** The Constant HOST. */
	protected static final String HOST = "host";

	// socketFactory.class
	/** The Constant SOCKETFACTORY_CLASS. */
	protected static final String SOCKETFACTORY_CLASS = "socketFactory.class";

	// socketFactory.fallback
	/** The Constant SOCKETFACTORY_FALLBACK. */
	protected static final String SOCKETFACTORY_FALLBACK = "socketFactory.fallback";

	// socketFactory.port
	/** The Constant SOCKETFACTORY_PORT. */
	protected static final String SOCKETFACTORY_PORT = "socketFactory.port";

	// connectiontimeout
	/** The Constant CONNECTIONTIMEOUT. */
	protected static final String CONNECTIONTIMEOUT = "connectiontimeout";

	// timeout
	/** The Constant TIMEOUT. */
	protected static final String TIMEOUT = "timeout";

	// localaddress
	/** The Constant LOCALADDRESS. */
	protected static final String LOCALADDRESS = "localaddress";

	// localport
	/** The Constant LOCALPORT. */
	protected static final String LOCALPORT = "localport";

	// starttls.enable
	/** The Constant STARTTLS_ENABLE. */
	protected static final String STARTTLS_ENABLE = "starttls.enable";

	// debug
	/** The Constant DEBUG. */
	protected static final String DEBUG = "debug";

	// mime
	/** The Constant MIME. */
	protected static final String MIME = "mime";

	// address.strict
	/** The Constant ADDRESS_STRICT. */
	protected static final String ADDRESS_STRICT = "address.strict";

	// class
	/** The Constant CLASS. */
	protected static final String CLASS = "class";

	// charset
	/** The Constant CHARSET. */
	protected static final String CHARSET = "charset";

	// decodetext.strict
	/** The Constant DECODETEXT_STRICT. */
	protected static final String DECODETEXT_STRICT = "decodetext.strict";

	// encodeeol.strict
	/** The Constant ENCODEEOL_STRICT. */
	protected static final String ENCODEEOL_STRICT = "encodeeol.strict";

	// base64.ignoreerrors
	/** The Constant BASE64_IGNOREERRORS. */
	protected static final String BASE64_IGNOREERRORS = "base64.ignoreerrors";

	// foldtext
	/** The Constant FOLDTEXT. */
	protected static final String FOLDTEXT = "foldtext";

	// setcontenttypefilename
	/** The Constant SETCONTENTTYPEFILENAME. */
	protected static final String SETCONTENTTYPEFILENAME = "setcontenttypefilename";

	// setdefaulttextcharset
	/** The Constant SETDEFAULTTEXTCHARSET. */
	protected static final String SETDEFAULTTEXTCHARSET = "setdefaulttextcharset";

	// multipart.ignoremissingendboundary
	/** The Constant MULTIPART_IGNOREMISSINGENDBOUNDARY. */
	protected static final String MULTIPART_IGNOREMISSINGENDBOUNDARY = "multipart.ignoremissingendboundary";

	// alternates
	/** The Constant ALTERNATES. */
	protected static final String ALTERNATES = "alternates";

	// replyallcc
	/** The Constant REPLYALLCC. */
	protected static final String REPLYALLCC = "replyallcc";

	// mail.mime.
	/** The Constant MAIL_MIME. */
	protected static final String MAIL_MIME = MAIL + DOT + MIME + DOT;

	// mail.protocol.
	/** The Constant MAIL_PROTOCOL. */
	protected static final String MAIL_PROTOCOL = MAIL + DOT + PROTOCOL + DOT;

	// GLOBAL end

	// SMTP start
	// smtp
	/** The Constant SMTP. */
	protected static final String SMTP = "smtp";

	// auth
	/** The Constant AUTH. */
	protected static final String AUTH = "auth";

	// from
	/** The Constant FROM. */
	protected static final String FROM = "from";

	// localhost
	/** The Constant LOCALHOST. */
	protected static final String LOCALHOST = "localhost";

	// ehlo
	/** The Constant EHLO. */
	protected static final String EHLO = "ehlo";

	// submitter
	/** The Constant SUBMITTER. */
	protected static final String SUBMITTER = "submitter";

	// dsn.notify
	/** The Constant DSN_NOTIFY. */
	protected static final String DSN_NOTIFY = "dsn.notify";

	// dsn.ret
	/** The Constant DSN_RET. */
	protected static final String DSN_RET = "dsn.ret";

	// allow8bitmime
	/** The Constant ALLOW8BITMIME. */
	protected static final String ALLOW8BITMIME = "allow8bitmime";

	// sendpartial
	/** The Constant SENDPARTIAL. */
	protected static final String SENDPARTIAL = "sendpartial";

	// sasl.realm
	/** The Constant SASL_REALM. */
	protected static final String SASL_REALM = "sasl.realm";

	// quitwait
	/** The Constant QUITWAIT. */
	protected static final String QUITWAIT = "quitwait";

	// reportsuccess
	/** The Constant REPORTSUCCESS. */
	protected static final String REPORTSUCCESS = "reportsuccess";

	// mailextension
	/** The Constant MAILEXTENSION. */
	protected static final String MAILEXTENSION = "mailextension";

	// userset
	/** The Constant USERSET. */
	protected static final String USERSET = "userset";

	/** Prefix for the smtp keys. */
	protected static final String MAIL_SMTP = MAIL + DOT + SMTP + DOT;

	// SMTP end

	// POP3 start
	// pop3
	/** The Constant POP3. */
	protected static final String POP3 = "pop3";

	// rsetbeforequit
	/** The Constant RSETBEFOREQUIT. */
	protected static final String RSETBEFOREQUIT = "rsetbeforequit";

	// message.class
	/** The Constant MESSAGE_CLASS. */
	protected static final String MESSAGE_CLASS = "message.class";

	// apop.enable
	/** The Constant APOP_ENABLE. */
	protected static final String APOP_ENABLE = "apop.enable";

	// disabletop
	/** The Constant DISABLETOP. */
	protected static final String DISABLETOP = "disabletop";

	// forgettopheaders
	/** The Constant FORGETTOPHEADERS. */
	protected static final String FORGETTOPHEADERS = "forgettopheaders";

	/** Prefix for the pop3 keys. */
	protected static final String MAIL_POP3 = MAIL + DOT + POP3 + DOT;

	// POP3 end
	// IMAP start
	// imap
	/** The Constant IMAP. */
	protected static final String IMAP = "imap";

	// partialfetch
	/** The Constant PARTIALFETCH. */
	protected static final String PARTIALFETCH = "partialfetch";

	// fetchsize
	/** The Constant FETCHSIZE. */
	protected static final String FETCHSIZE = "fetchsize";

	// statuscachetimeout
	/** The Constant STATUSCACHETIMEOUT. */
	protected static final String STATUSCACHETIMEOUT = "statuscachetimeout";

	// appendbuffersize
	/** The Constant APPENDBUFFERSIZE. */
	protected static final String APPENDBUFFERSIZE = "appendbuffersize";

	// connectionpoolsize
	/** The Constant CONNECTIONPOOLSIZE. */
	protected static final String CONNECTIONPOOLSIZE = "connectionpoolsize";

	// connectionpooltimeout
	/** The Constant CONNECTIONPOOLTIMEOUT. */
	protected static final String CONNECTIONPOOLTIMEOUT = "connectionpooltimeout";

	// separatestoreconnection
	/** The Constant SEPARATESTORECONNECTION. */
	protected static final String SEPARATESTORECONNECTION = "separatestoreconnection";

	// allowreadonlyselect
	/** The Constant ALLOWREADONLYSELECT. */
	protected static final String ALLOWREADONLYSELECT = "allowreadonlyselect";

	// auth.login.disable
	/** The Constant AUTH_LOGIN_DISABLE. */
	protected static final String AUTH_LOGIN_DISABLE = "auth.login.disable";

	// auth.plain.disable
	/** The Constant AUTH_PLAIN_DISABLE. */
	protected static final String AUTH_PLAIN_DISABLE = "auth.plain.disable";

	// sasl.enable
	/** The Constant SASL_ENABLE. */
	protected static final String SASL_ENABLE = "sasl.enable";

	// sasl.mechanisms
	/** The Constant SASL_MECHANISMS. */
	protected static final String SASL_MECHANISMS = "sasl.mechanisms";

	// sasl.authorizationid
	/** The Constant SASL_AUTHORIZATIONID. */
	protected static final String SASL_AUTHORIZATIONID = "sasl.authorizationid";

	/** Prefix for the imap keys. */
	protected static final String MAIL_IMAP = MAIL + DOT + IMAP + DOT;

	// IMAP ends
}