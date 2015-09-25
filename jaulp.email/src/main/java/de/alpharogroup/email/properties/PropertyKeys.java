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
 * Helper-class for the keys from the email-properties. All the documentation is from the different
 * packages "com.sun.mail.imap, com.sun.mail.pop3, com.sun.mail.smtp". For detailed information see
 * the JavaMail API.
 *
 * @author Asterios Raptis
 */
public abstract class PropertyKeys extends MailPropertiesConst
{

	// GLOBAL start
	/**
	 * This is the key for the property "mail.debug". The value is the initial debug mode. Default
	 * is false. Type:boolean
	 */
	public static final String MAIL_DEBUG = MAIL + DOT + DEBUG;

	/**
	 * This is the key for the property "mail.debug". The value is the return email address of the
	 * current user, used by the InternetAddress method getLocalAddress. Type:String
	 */
	public static final String MAIL_FROM = MAIL + DOT + FROM;

	/**
	 * This is the key for the property "mail.user". The value is the default user name to use when
	 * connecting to the mail server. Used if the mail.protocol.user property isn't set. Type:String
	 */
	public static final String MAIL_USER = MAIL + DOT + USER;

	/**
	 * This is the key for the property "mail.host". The value is the default host name of the mail
	 * server for both Stores and Transports. Used if the mail.protocol.host property isn't set.
	 * Type:String
	 */
	public static final String MAIL_HOST = MAIL + DOT + HOST;

	/**
	 * This is the key for the property "mail.alternates". The value is a string containing other
	 * email addresses that the current user is known by. The MimeMessage reply method will
	 * eliminate any of these addresses from the recipient list in the message it constructs, to
	 * avoid sending the reply back to the sender. Type:String
	 *
	 */
	public static final String MAIL_ALTERNATES = MAIL + ALTERNATES;

	/**
	 * This is the key for the property "mail.replyallcc". If the value is set to "true", the
	 * MimeMessage reply method will put all recipients except the original sender in the Cc list of
	 * the newly constructed message. Normally, recipients in the To header of the original message
	 * will also appear in the To list of the newly constructed message. Type:boolean
	 *
	 */
	public static final String MAIL_REPLYALLCC = MAIL + REPLYALLCC;

	/**
	 * This is the key for the property "mail.transport.protocol". The value specifies the default
	 * message access protocol. The Session method getTransport() returns a Transport object that
	 * implements this protocol. By default the first Transport provider in the configuration files
	 * is returned. Type:String
	 */
	public static final String MAIL_TRANSPORT_PROTOCOL = MAIL + DOT + TRANSPORT + DOT + PROTOCOL;

	/**
	 * This is the key for the property "mail.store.protocol". The value specifies the default
	 * message access protocol. The Session method getStore() returns a Store object that implements
	 * this protocol. By default the first Store provider in the configuration files is returned.
	 * Type:String
	 */
	public static final String MAIL_STORE_PROTOCOL = MAIL + DOT + STORE + DOT + PROTOCOL;

	/**
	 * This is the key for the property "mail.user". The value specifies the fully qualified class
	 * name of the provider for the specified protocol. Used in cases where more than one provider
	 * for a given protocol exists; this property can be used to specify which provider to use by
	 * default. The provider must still be listed in a configuration file. Type:String
	 *
	 */
	public static final String MAIL_PROTOCOL_CLASS = MAIL_PROTOCOL + CLASS;

	/**
	 * This is the key for the property "mail.protocol.host". The value is the host name of the mail
	 * server for the specified protocol. Overrides the mail.host property. Type:String
	 */
	public static final String MAIL_PROTOCOL_HOST = MAIL_PROTOCOL + HOST;

	/**
	 * This is the key for the property "mail.protocol.port". The value is the port number of the
	 * mail server for the specified protocol. If not specified the protocol's default port number
	 * is used. Type:int
	 */
	public static final String MAIL_PROTOCOL_PORT = MAIL_PROTOCOL + PORT;

	/**
	 * This is the key for the property "mail.protocol.user". The value is the user name to use when
	 * connecting to mail servers using the specified protocol. Overrides the mail.user property.
	 * Type:String
	 */
	public static final String MAIL_PROTOCOL_USER = MAIL_PROTOCOL + USER;

	/**
	 * This is the key for the property "mail.mime.address.strict". The value is the MimeMessage
	 * class uses the InternetAddress method parseHeader to parse headers in messages. This property
	 * controls the strict flag passed to the parseHeader method. The default is true. Type:boolean
	 */
	public static final String MAIL_MIME_ADDRESS_STRICT = MAIL_MIME + ADDRESS_STRICT;

	/**
	 * This is the key for the property "mail.mime.charset". The value is the default charset to be
	 * used by JavaMail. If not set (the normal case), the standard J2SE file.encoding System
	 * property is used. This allows applications to specify a default character set for sending
	 * messages that's different than the character set used for files stored on the system. This is
	 * common on Japanese systems. Type:String
	 *
	 */
	public static final String MAIL_MIME_CHARSET = MAIL_MIME + CHARSET;

	/**
	 * This is the key for the property "mail.mime.decodetext.strict". RFC 2047 requires that
	 * encoded text start at the beginning of a whitespace separated word. Some mailers, especially
	 * Japanese mailers, improperly encode text and include encoded text in the middle of words. The
	 * value of this property controls whether JavaMail will attempt to decode such incorrectly
	 * encoded text. The default is true, meaning that JavaMail wil not attempt to decode such
	 * improperly decoded text. Type:boolean
	 *
	 */
	public static final String MAIL_MIME_DECODETEXT_STRICT = MAIL_MIME + DECODETEXT_STRICT;

	/**
	 * This is the key for the property "mail.mime.encodeeol.strict". When choosing an encoding for
	 * the data of a message, JavaMail assumes that any of CR, LF, or CRLF are valid line
	 * terminators in message parts that contain only printable ASCII characters, even if the part
	 * is not a MIME text type. It's common, especially on UNIX systems, for data of MIME type
	 * application/octet-stream (for example) to really be textual data that should be transmitted
	 * with the encoding rules for MIME text. In rare cases, such pure ASCII text may in fact be
	 * binary data in which the CR and LF characters must be preserved exactly. If the value of this
	 * property is set to true, JavaMail will consider a lone CR or LF in a body part that's not a
	 * MIME text type to indicate that the body part needs to be encoded. The default is false.
	 * Type:boolean
	 *
	 */
	public static final String MAIL_MIME_ENCODEEOL_STRICT = MAIL_MIME + ENCODEEOL_STRICT;

	/**
	 * This is the key for the property "mail.mime.base64.ignoreerrors". If the value is set to
	 * "true", the BASE64 decoder will ignore errors in the encoded data, returning EOF. This may be
	 * useful when dealing with improperly encoded messages that contain extraneous data at the end
	 * of the encoded stream. Note however that errors anywhere in the stream will cause the decoder
	 * to stop decoding so this should be used with extreme caution. The default is false.
	 * Type:boolean
	 *
	 */
	public static final String MAIL_MIME_BASE64_IGNOREERRORS = MAIL_MIME + BASE64_IGNOREERRORS;

	/**
	 * This is the key for the property "mail.mime.foldtext". If the value is set to "true", header
	 * fields containing just text such as the Subject and Content-Description header fields, and
	 * long parameter values in structured headers such as Content-Type will be folded (broken into
	 * 76 character lines) when set and unfolded when read. The default is true. Type:boolean
	 *
	 */
	public static final String MAIL_MIME_FOLDTEXT = MAIL_MIME + FOLDTEXT;

	/**
	 * This is the key for the property "mail.mime.setcontenttypefilename". If the value is set to
	 * "true", the setFileName method will also set the name parameter on the Content-Type header to
	 * the specified filename. This supports interoperability with some old mail clients. The
	 * default is true. Type:boolean
	 *
	 */
	public static final String MAIL_MIME_SETCONTENTTYPEFILENAME = MAIL_MIME
		+ SETCONTENTTYPEFILENAME;

	/**
	 * This is the key for the property "mail.mime.setdefaulttextcharset". When updating the headers
	 * of a message, a body part with a text content type but no charset parameter will have a
	 * charset parameter added to it if the value of this property is set to "true". The default is
	 * true. Type:boolean
	 *
	 */
	public static final String MAIL_MIME_SETDEFAULTTEXTCHARSET = MAIL_MIME + SETDEFAULTTEXTCHARSET;

	/**
	 * This is the key for the property "mail.mime.multipart.ignoremissingendboundary". Normally,
	 * when parsing a multipart MIME message, a message that is missing the final end boundary line
	 * is not considered an error. The data simply ends at the end of the input. Note that messages
	 * of this form violate the MIME specification. If the property
	 * mail.mime.multipart.ignoremissingendboundary is set to false, such messages are considered an
	 * error and a MesagingException will be thrown when parsing such a message. Type:boolean
	 *
	 */
	public static final String MAIL_MIME_MULTIPART_IGNOREMISSINGENDBOUNDARY = MAIL_MIME
		+ MULTIPART_IGNOREMISSINGENDBOUNDARY;

	// GLOBAL end

	// POP3 start
	/**
	 * This is the key for the property "mail.pop3.user". The value is the default user name for
	 * POP3.
	 */
	public static final String MAIL_POP3_USER = MAIL_POP3 + USER;

	/**
	 * This is the key for the property "mail.pop3.host". The value is the POP3 server to connect
	 * to.
	 */
	public static final String MAIL_POP3_HOST = MAIL_POP3 + HOST;

	/**
	 * This is the key for the property "mail.pop3.port". The value is the POP3 server port to
	 * connect to, if the connect() method doesn't explicitly specify one. Defaults to 110.
	 */
	public static final String MAIL_POP3_PORT = MAIL_POP3 + PORT;

	/**
	 * This is the key for the property "mail.pop3.connectiontimeout". The value is the socket
	 * connection timeout value in milliseconds. Default is infinite timeout.
	 */
	public static final String MAIL_POP3_CONNECTIONTIMEOUT = MAIL_POP3 + CONNECTIONTIMEOUT;

	/**
	 * This is the key for the property "mail.pop3.connectiontimeout". The value is the socket
	 * connection timeout value in milliseconds. Default is infinite timeout.
	 */
	public static final String MAIL_POP3_TIMEOUT = MAIL_POP3 + TIMEOUT;

	/**
	 * This is the key for the property "mail.pop3.rsetbeforequit". The value send a POP3 RSET
	 * command when closing the folder, before sending the QUIT command. Useful with POP3 servers
	 * that implicitly mark all messages that are read as "deleted"; this will prevent such messages
	 * from being deleted and expunged unless the client requests so. Default is false.
	 */
	public static final String MAIL_POP3_RSETBEFOREQUIT = MAIL_POP3 + RSETBEFOREQUIT;

	/**
	 * This is the key for the property "mail.pop3.message.class". The value is the class name of a
	 * subclass of com.sun.mail.pop3.POP3Message. The subclass can be used to handle (for example)
	 * non-standard Content-Type headers. The subclass must have a public constructor of the form
	 * MyPOP3Message(Folder f, int msgno) throws MessagingException.
	 */
	public static final String MAIL_POP3_MESSAGE_CLASS = MAIL_POP3 + MESSAGE_CLASS;

	/**
	 * This is the key for the property "mail.pop3.localaddress". The value is the local address
	 * (host name) to bind to when creating the POP3 socket. Defaults to the address picked by the
	 * Socket class. Should not normally need to be set, but useful with multi-homed hosts where
	 * it's important to pick a particular local address to bind to.
	 */
	public static final String MAIL_POP3_LOCALADDRESS = MAIL_POP3 + LOCALADDRESS;

	/**
	 * This is the key for the property "mail.pop3.localport". The value is the local port number to
	 * bind to when creating the POP3 socket. Defaults to the port number picked by the Socket
	 * class.
	 */
	public static final String MAIL_POP3_LOCALPORT = MAIL_POP3 + LOCALPORT;

	/**
	 * This is the key for the property "mail.pop3.apop.enable". If the value is set to true, use
	 * APOP instead of USER/PASS to login to the POP3 server, if the POP3 server supports APOP. APOP
	 * sends a digest of the password rather than the clear text password. Defaults to false.
	 */
	public static final String MAIL_POP3_APOP_ENABLE = MAIL_POP3 + APOP_ENABLE;

	/**
	 * This is the key for the property "mail.pop3.socketFactory.class". If the value is set, it
	 * specifies the name of a class that implements the javax.net.SocketFactory interface. This
	 * class will be used to create POP3 sockets.
	 */
	public static final String MAIL_POP3_SOCKETFACTORY_CLASS = MAIL_POP3 + SOCKETFACTORY_CLASS;

	/**
	 * This is the key for the property "mail.pop3.socketFactory.fallback". If the value is set to
	 * true, failure to create a socket using the specified socket factory class will cause the
	 * socket to be created using the java.net.Socket class. Defaults to true.
	 */
	public static final String MAIL_POP3_SOCKETFACTORY_FALLBACK = MAIL_POP3
		+ SOCKETFACTORY_FALLBACK;

	/**
	 * This is the key for the property "mail.pop3.socketFactory.port". The value specifies the port
	 * to connect to when using the specified socket factory. If not set, the default port will be
	 * used.
	 */
	public static final String MAIL_POP3_SOCKETFACTORY_PORT = MAIL_POP3 + SOCKETFACTORY_PORT;

	/**
	 * This is the key for the property "mail.pop3.disabletop". If the value is set to true, the
	 * POP3 TOP command will not be used to fetch message headers. This is useful for POP3 servers
	 * that don't properly implement the TOP command, or that provide incorrect information in the
	 * TOP command results. Defaults to false.
	 */
	public static final String MAIL_POP3_DISABLETOP = MAIL_POP3 + DISABLETOP;

	/**
	 * This is the key for the property "mail.pop3.forgettopheaders". If the value is set to true,
	 * the headers that might have been retrieved using the POP3 TOP command will be forgotten and
	 * replaced by headers retrieved as part of the POP3 RETR command. Some servers, such as some
	 * version of Microsft Exchange, will return slightly different headers each time the TOP or
	 * RETR command is used. To allow the POP3 provider to properly parse the message content
	 * returned from the RETR command, the headers also returned by the RETR command must be used.
	 * Setting this property to true will cause these headers to be used, even if they differ from
	 * the headers returned previously as a result of using the TOP command. Defaults to false.
	 */
	public static final String MAIL_POP3_FORGETTOPHEADERS = MAIL_POP3 + FORGETTOPHEADERS;

	// POP3 end

	// IMAP start

	/**
	 * This is the key for the property "mail.imap.user". The value is the default user name for
	 * IMAP. Type:String
	 */
	public static final String MAIL_IMAP_USER = MAIL_IMAP + USER;

	/**
	 * This is the key for the property "mail.imap.password". The value is the password for the user
	 * for IMAP. Type:String
	 */
	public static final String MAIL_IMAP_PASSWORD = MAIL_IMAP + PASSWORD;

	/**
	 * This is the key for the property "mail.imap.host". The value is the IMAP server to connect
	 * to. Type:String
	 */
	public static final String MAIL_IMAP_HOST = MAIL_IMAP + HOST;

	/**
	 * This is the key for the property "mail.imap.port". The value is the IMAP server port to
	 * connect to, if the connect() method doesn't explicitly specify one. Defaults to 143. Type:int
	 */
	public static final String MAIL_IMAP_PORT = MAIL_IMAP + PORT;

	/**
	 * This is the key for the property "mail.imap.partialfetch". The value controls whether the
	 * IMAP partial-fetch capability should be used. Defaults to true. Type:boolean
	 */
	public static final String MAIL_IMAP_PARTIALFETCH = MAIL_IMAP + PARTIALFETCH;

	/**
	 * This is the key for the property "mail.imap.fetchsize". The value is the partial fetch size
	 * in bytes. Defaults to 16K. Type:int
	 */
	public static final String MAIL_IMAP_FETCHSIZE = MAIL_IMAP + FETCHSIZE;

	/**
	 * This is the key for the property "mail.imap.connectiontimeout". The value is the socket
	 * connection timeout value in milliseconds. Default is infinite timeout. Type:int
	 */
	public static final String MAIL_IMAP_CONNECTIONTIMEOUT = MAIL_IMAP + CONNECTIONTIMEOUT;

	/**
	 * This is the key for the property "mail.imap.timeout". The value is the socket I/O timeout
	 * value in milliseconds. Default is infinite timeout. Type:int
	 */
	public static final String MAIL_IMAP_TIMEOUT = MAIL_IMAP + TIMEOUT;

	/**
	 * This is the key for the property "mail.imap.statuscachetimeout". The value is the timeout
	 * value in milliseconds for cache of STATUS command response. Default is 1000 (1 second). Zero
	 * disables cache. Type:int
	 */
	public static final String MAIL_IMAP_STATUSCACHETIMEOUT = MAIL_IMAP + STATUSCACHETIMEOUT;

	/**
	 * This is the key for the property "mail.imap.appendbuffersize". The value is the maximum size
	 * of a message to buffer in memory when appending to an IMAP folder. If not set, or set to -1,
	 * there is no maximum and all messages are buffered. If set to 0, no messages are buffered. If
	 * set to (e.g.) 8192, messages of 8K bytes or less are buffered, larger messages are not
	 * buffered. Buffering saves cpu time at the expense of short term memory usage. If you commonly
	 * append very large messages to IMAP mailboxes you might want to set this to a moderate value
	 * (1M or less). Type:int
	 */
	public static final String MAIL_IMAP_APPENDBUFFERSIZE = MAIL_IMAP + APPENDBUFFERSIZE;

	/**
	 * This is the key for the property "mail.imap.connectionpoolsize". The value is the maximum
	 * number of available connections in the connection pool. Default is 1. Type:int
	 */
	public static final String MAIL_IMAP_CONNECTIONPOOLSIZE = MAIL_IMAP + CONNECTIONPOOLSIZE;

	/**
	 * This is the key for the property "mail.imap.connectionpooltimeout". The value is the timeout
	 * value in milliseconds for connection pool connections. Default is 45000 (45 seconds).
	 * Type:int
	 */
	public static final String MAIL_IMAP_CONNECTIONPOOLTIMEOUT = MAIL_IMAP + CONNECTIONPOOLTIMEOUT;

	/**
	 * This is the key for the property "mail.imap.separatestoreconnection". The value is a flag to
	 * indicate whether to use a dedicated store connection for store commands. Default is false.
	 * Type:boolean
	 */
	public static final String MAIL_IMAP_SEPARATESTORECONNECTION = MAIL_IMAP
		+ SEPARATESTORECONNECTION;

	/**
	 * This is the key for the property "mail.imap.allowreadonlyselect". If the value is set to
	 * false, attempts to open a folder read/write will fail if the SELECT command succeeds but
	 * indicates that the folder is READ-ONLY. This sometimes indicates that the folder contents
	 * can'tbe changed, but the flags are per-user and can be changed, such as might be the case for
	 * public shared folders. If true, such open attempts will succeed, allowing the flags to be
	 * changed. The getMode method on the Folder object will return Folder.READ_ONLY in this case
	 * even though the open method specified Folder.READ_WRITE. Default is false. Type:boolean
	 */
	public static final String MAIL_IMAP_ALLOWREADONLYSELECT = MAIL_IMAP + ALLOWREADONLYSELECT;

	/**
	 * This is the key for the property "mail.imap.auth.login.disable". If the value is set to true,
	 * prevents use of the non-standard AUTHENTICATE LOGIN command, instead using the plain LOGIN
	 * command. Default is false. Type:boolean
	 */
	public static final String MAIL_IMAP_AUTH_LOGIN_DISABLE = MAIL_IMAP + AUTH_LOGIN_DISABLE;

	/**
	 * This is the key for the property "mail.imap.auth.plain.disable". If the value is set to true,
	 * prevents use of the AUTHENTICATE PLAIN command. Default is false. Type:boolean
	 */
	public static final String MAIL_IMAP_AUTH_PLAIN_DISABLE = MAIL_IMAP + AUTH_PLAIN_DISABLE;

	/**
	 * This is the key for the property "mail.imap.starttls.enable". If the value is set to true,
	 * enables the use of the STARTTLS command (if supported by the server) to switch the connection
	 * to a TLS-protected connection before issuing any login commands. Note that an appropriate
	 * trust store must configured so that the client will trust the server's certificate. This
	 * feature only works on J2SE 1.4 and newer systems. Default is false. Type:boolean
	 */
	public static final String MAIL_IMAP_STARTTLS_ENABLE = MAIL_IMAP + STARTTLS_ENABLE;

	/**
	 * This is the key for the property "mail.imap.localaddress". The value is the local address
	 * (host name) to bind to when creating the IMAP socket. Defaults to the address picked by the
	 * Socket class. Should not normally need to be set, but useful with multi-homed hosts where
	 * it's important to pick a particular local address to bind to. Type:String
	 */
	public static final String MAIL_IMAP_LOCALADDRESS = MAIL_IMAP + LOCALADDRESS;

	/**
	 * This is the key for the property "mail.imap.localport". The value is the local port number to
	 * bind to when creating the IMAP socket. Defaults to the port number picked by the Socket
	 * class. Type:int
	 */
	public static final String MAIL_IMAP_LOCALPORT = MAIL_IMAP + LOCALPORT;

	/**
	 * This is the key for the property "mail.imap.sasl.enable". If the value is set to true,
	 * attempt to use the javax.security.sasl package to choose an authentication mechanism for
	 * login. Defaults to false. Type:boolean
	 */
	public static final String MAIL_IMAP_SASL_ENABLE = MAIL_IMAP + SASL_ENABLE;

	/**
	 * This is the key for the property "mail.imap.sasl.mechanisms". The value is a space or comma
	 * separated list of SASL mechanism names to try to use. Type:String
	 */
	public static final String MAIL_IMAP_SASL_MECHANISMS = MAIL_IMAP + SASL_MECHANISMS;

	/**
	 * This is the key for the property "mail.imap.sasl.authorizationid". The value specifies the
	 * authorization ID to use in the SASL authentication. If not set, the authentication ID (user
	 * name) is used. Type:String
	 */
	public static final String MAIL_IMAP_SASL_AUTHORIZATIONID = MAIL_IMAP + SASL_AUTHORIZATIONID;

	/**
	 * This is the key for the property "mail.imap.socketFactory.class". If the value is set,
	 * specifies the name of a class that implements the javax.net.SocketFactory interface. This
	 * class will be used to create IMAP sockets. Type:String
	 */
	public static final String MAIL_IMAP_SOCKETFACTORY_CLASS = MAIL_IMAP + SOCKETFACTORY_CLASS;

	/**
	 * This is the key for the property "mail.imap.socketFactory.fallback". If the value is set to
	 * true, failure to create a socket using the specified socket factory class will cause the
	 * socket to be created using the java.net.Socket class. Defaults to true. Type:boolean
	 */
	public static final String MAIL_IMAP_SOCKETFACTORY_FALLBACK = MAIL_IMAP
		+ SOCKETFACTORY_FALLBACK;

	/**
	 * This is the key for the property "mail.imap.socketFactory.port". The value specifies the port
	 * to connect to when using the specified socket factory. If not set, the default port will be
	 * used. Type:int
	 */
	public static final String MAIL_IMAP_SOCKETFACTORY_PORT = MAIL_IMAP + SOCKETFACTORY_PORT;

	// IMAP end

	// SMTP start
	/**
	 * This is the key for the property "mail.smtp.user". The value is the default user name for
	 * SMTP. Type:String
	 */
	public static final String MAIL_SMTP_USER = MAIL_SMTP + USER;

	/**
	 * This is the key for the property "mail.smtp.host". The value is the SMTP server to connect
	 * to. Type:String
	 */
	public static final String MAIL_SMTP_HOST = MAIL_SMTP + HOST;

	/**
	 * This is the key for the property "mail.smtp.port". The value is the SMTP server port to
	 * connect to, if the connect() method doesn't explicitly specify one. Defaults to 25. Type:int
	 */
	public static final String MAIL_SMTP_PORT = MAIL_SMTP + PORT;

	/**
	 * This is the key for the property "mail.smtp.connectiontimeout". The value is the socket
	 * connection timeout value in milliseconds. Default is infinite timeout. Type:int
	 */
	public static final String MAIL_SMTP_CONNECTIONTIMEOUT = MAIL_SMTP + CONNECTIONTIMEOUT;

	/**
	 * This is the key for the property "mail.smtp.timeout". The value is the socket I/O timeout
	 * value in milliseconds. Default is infinite timeout. Type:int
	 */
	public static final String MAIL_SMTP_TIMEOUT = MAIL_SMTP + TIMEOUT;

	/**
	 * This is the key for the property "mail.smtp.from". The value is the email address to use for
	 * SMTP MAIL command. This sets the envelope return address. Defaults to msg.getFrom() or
	 * InternetAddress.getLocalAddress(). NOTE: mail.smtp.user was previously used for this.
	 * Type:String
	 */
	public static final String MAIL_SMTP_FROM = MAIL_SMTP + FROM;

	/**
	 * This is the key for the property "mail.smtp.localhost". The value is the local host name used
	 * in the SMTP HELO or EHLO command. Defaults to InetAddress.getLocalHost().getHostName().
	 * Should not normally need to be set if your JDK and your name service are configured properly.
	 * Type:String
	 */
	public static final String MAIL_SMTP_LOCALHOST = MAIL_SMTP + LOCALHOST;

	/**
	 * This is the key for the property "mail.smtp.localaddress". The value is the local address
	 * (host name) to bind to when creating the SMTP socket. Defaults to the address picked by the
	 * Socket class. Should not normally need to be set, but useful with multi-homed hosts where
	 * it's important to pick a particular local address to bind to. Type:String
	 */
	public static final String MAIL_SMTP_LOCALADDRESS = MAIL_SMTP + LOCALADDRESS;

	/**
	 * This is the key for the property "mail.smtp.localport". The value is the local port number to
	 * bind to when creating the SMTP socket. Defaults to the port number picked by the Socket
	 * class. Type:int
	 */
	public static final String MAIL_SMTP_LOCALPORT = MAIL_SMTP + LOCALPORT;

	/**
	 * This is the key for the property "mail.smtp.ehlo". If the value is set to false, do not
	 * attempt to sign on with the EHLO command. Defaults to true. Normally failure of the EHLO
	 * command will fallback to the HELO command; this property exists only for servers that don't
	 * fail EHLO properly or don't implement EHLO properly. Type:boolean
	 */
	public static final String MAIL_SMTP_EHLO = MAIL_SMTP + EHLO;

	/**
	 * This is the key for the property "mail.smtp.auth". If the value is set to true, attempt to
	 * authenticate the user using the AUTH command. Defaults to false. Type:boolean
	 */
	public static final String MAIL_SMTP_AUTH = MAIL_SMTP + AUTH;

	/**
	 * This is the key for the property "mail.smtp.submitter". The value is the submitter to use in
	 * the AUTH tag in the MAIL FROM command. Typically used by a mail relay to pass along
	 * information about the original submitter of the message. See also the setSubmitter method of
	 * SMTPMessage. Mail clients typically do not use this. Type:String
	 */
	public static final String MAIL_SMTP_SUBMITTER = MAIL_SMTP + SUBMITTER;

	/**
	 * This is the key for the property "mail.smtp.dsn.notify". The value is the NOTIFY option to
	 * the RCPT command. Either NEVER, or some combination of SUCCESS, FAILURE, and DELAY (separated
	 * by commas). Type:String
	 */
	public static final String MAIL_SMTP_DSN_NOTIFY = MAIL_SMTP + DSN_NOTIFY;

	/**
	 * This is the key for the property "mail.smtp.dsn.ret". The value is the RET option to the MAIL
	 * command. Either FULL or HDRS. Type:String
	 */
	public static final String MAIL_SMTP_DSN_RET = MAIL_SMTP + DSN_RET;

	/**
	 * This is the key for the property "mail.smtp.allow8bitmime". If the value is set to true, and
	 * the server supports the 8BITMIME extension, text parts of messages that use the
	 * "quoted-printable" or "base64" encodings are converted to use "8bit" encoding if they follow
	 * the RFC2045 rules for 8bit text. Type:boolean
	 */
	public static final String MAIL_SMTP_ALLOW8BITMIME = MAIL_SMTP + ALLOW8BITMIME;

	/**
	 * This is the key for the property "mail.smtp.sendpartial". If the value is set to true, and a
	 * message has some valid and some invalid addresses, send the message anyway, reporting the
	 * partial failure with a SendFailedException. If set to false (the default), the message is not
	 * sent to any of the recipients if there is an invalid recipient address. Type:boolean
	 */
	public static final String MAIL_SMTP_SENDPARTIAL = MAIL_SMTP + SENDPARTIAL;

	/**
	 * This is the key for the property "mail.smtp.sasl.realm". The value specifies the realm to use
	 * with DIGEST-MD5 authentication. Type:String
	 */
	public static final String MAIL_SMTP_SASL_REALM = MAIL_SMTP + SASL_REALM;

	/**
	 * This is the key for the property "mail.smtp.quitwait". If the value is set to false, the QUIT
	 * command is sent and the connection is immediately closed. If set to true (the default),
	 * causes the transport to wait for the response to the QUIT command. Type:boolean
	 */
	public static final String MAIL_SMTP_QUITWAIT = MAIL_SMTP + QUITWAIT;

	/**
	 * This is the key for the property "mail.smtp.reportsuccess". If the value is set to true,
	 * causes the transport to include an SMTPAddressSucceededException for each address that is
	 * successful. Note also that this will cause a SendFailedException to be thrown from the
	 * sendMessage method of SMTPTransport even if all addresses were correct and the message was
	 * sent successfully. Type:boolean
	 */
	public static final String MAIL_SMTP_REPORTSUCCESS = MAIL_SMTP + REPORTSUCCESS;

	/**
	 * This is the key for the property "mail.smtp.socketFactory.class". If the value is set, it
	 * specifies the name of a class that implements the javax.net.SocketFactory interface. This
	 * class will be used to create SMTP sockets. Type:String
	 */
	public static final String MAIL_SMTP_SOCKETFACTORY_CLASS = MAIL_SMTP + SOCKETFACTORY_CLASS;

	/**
	 * This is the key for the property "mail.smtp.socketFactory.fallback". If the value is set to
	 * true, failure to create a socket using the specified socket factory class will cause the
	 * socket to be created using the java.net.Socket class. Defaults to true. Type:boolean
	 */
	public static final String MAIL_SMTP_SOCKETFACTORY_FALLBACK = MAIL_SMTP
		+ SOCKETFACTORY_FALLBACK;

	/**
	 * This is the key for the property "mail.smtp.socketFactory.port". The value specifies the port
	 * to connect to when using the specified socket factory. If not set, the default port will be
	 * used. Type:int
	 */
	public static final String MAIL_SMTP_SOCKETFACTORY_PORT = MAIL_SMTP + SOCKETFACTORY_PORT;

	/**
	 * This is the key for the property "mail.smtp.mailextension". The value is an Extension string
	 * to append to the MAIL command. The extension string can be used to specify standard SMTP
	 * service extensions as well as vendor-specific extensions. Typically the application should
	 * use the SMTPTransport method supportsExtension to verify that the server supports the desired
	 * service extension. See RFC 1869 and other RFCs that define specific extensions. Type:String
	 */
	public static final String MAIL_SMTP_MAILEXTENSION = MAIL_SMTP + MAILEXTENSION;

	/**
	 * This is the key for the property "mail.smtp.starttls.enable". If the value is true, it
	 * enables the use of the STARTTLS command (if supported by the server) to switch the connection
	 * to a TLS-protected connection before issuing any login commands. Note that an appropriate
	 * trust store must configured so that the client will trust the server's certificate. Defaults
	 * to false. Type:boolean
	 */
	public static final String MAIL_SMTP_STARTTLS_ENABLE = MAIL_SMTP + STARTTLS_ENABLE;

	/**
	 * This is the key for the property "mail.smtp.userset". If the value is set to true, use the
	 * RSET command instead of the NOOP command in the isConnected method. In some cases sendmail
	 * will respond slowly after many NOOP commands; use of RSET avoids this sendmail issue.
	 * Defaults to false. Type:boolean
	 */
	public static final String MAIL_SMTP_USERSET = MAIL_SMTP + USERSET;

	// SMTP end

}
