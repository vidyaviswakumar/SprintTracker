package com.me.app.springView;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfReportView extends AbstractPdfView{

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			Map<String,String> storyData = (Map<String,String>) model.get("storyData");
		
		Table table = new Table(2);
		table.addCell("Story Title");
		table.addCell("Status");
		
		for (Map.Entry<String, String> entry : storyData.entrySet()) {
			table.addCell(entry.getKey());
			table.addCell(entry.getValue());
                }

		document.add(table);
		
	}

}
