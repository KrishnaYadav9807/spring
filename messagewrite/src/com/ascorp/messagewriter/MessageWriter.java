package com.ascorp.messagewriter;

public class MessageWriter {

	public void writeMessage(String userInputMessage) {

		// 1. Format the Message In HTML.

		HtmlMessageFormater htmlMessageFormater = new HtmlMessageFormater();
		String htmlMessage = htmlMessageFormater.formatMessage(userInputMessage);

		// Formatting the In Html Format Has Completed

		// 2. Format the Message In PDF.

		PDFMessageFormatter pdfMessageFormatter = new PDFMessageFormatter();

		String PdfMessage = pdfMessageFormatter.formatMessage(userInputMessage);
		
		// Formatting the In PDF Format Has Completed
		
		// 3. Format the Message In DOC
		
		DocMessageFormater docMessageFormater = new  DocMessageFormater();
		String DocMessage = docMessageFormater.formatMessage(userInputMessage);
		
		// Formatting the In DOC Format Has Completed
		
		System.out.println(DocMessage);
	}
}
