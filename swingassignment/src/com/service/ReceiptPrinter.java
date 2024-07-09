package com.service;

import javax.swing.*;
import java.awt.*;
import java.awt.print.*;

public class ReceiptPrinter implements Printable {

    private JTable table;
    private String customerName;
    private int billNo;
    private double totalAmount;

    public ReceiptPrinter(JTable table, String customerName, int billNo, double totalAmount) {
        this.table = table;
        this.customerName = customerName;
        this.billNo = billNo;
        this.totalAmount = totalAmount;
    }

    @Override
    public int print(Graphics g, PageFormat pf, int page) throws PrinterException {
        if (page > 0) { // We only have one page
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pf.getImageableX(), pf.getImageableY());
        
        
        
     // Set the font for the heading
        Font originalFont = g2d.getFont();
        Font headingFont = new Font("Serif", Font.BOLD, 24);
        g2d.setFont(headingFont);

        // Draw the heading in the center
        String heading = "Quick Mart";
        FontMetrics fm = g2d.getFontMetrics();
        int headingWidth = fm.stringWidth(heading);
        int headingX = (int) ((pf.getImageableWidth() - headingWidth) / 2);
        g2d.drawString(heading, headingX, 120);

        // Reset the font to original
        g2d.setFont(originalFont);
        
        

        int y = 145;

        g.drawString("Customer Name: " + customerName, 100, y += 20);
        g.drawString("Bill No: " + billNo, 100, y += 20);
        g.drawString("Total Amount: " + totalAmount, 100, y += 20);

        y += 40; // Space before table

        // Print table headers
        for (int i = 0; i < table.getColumnCount(); i++) {
            g.drawString(table.getColumnName(i), 100 + i * 100, y);
        }

        // Print table rows
        for (int row = 0; row < table.getRowCount(); row++) {
            y += 20;
            for (int col = 0; col < table.getColumnCount(); col++) {
                g.drawString(table.getValueAt(row, col).toString(), 100 + col * 100, y);
            }
        }

        return PAGE_EXISTS;
    }

    public void printReceipt() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.setPrintable(this);
        boolean doPrint = job.printDialog();
        if (doPrint) {
            try {
                job.print();
            } catch (PrinterException e) {
                e.printStackTrace();
            }
        }
    }
}

