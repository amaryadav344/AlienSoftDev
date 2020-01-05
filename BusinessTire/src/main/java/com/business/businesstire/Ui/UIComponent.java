package com.business.businesstire.Ui;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.*;
import java.awt.*;

public class UIComponent {
    JTextPane jTextPane;

    public void CreateLayout() throws BadLocationException {
        JFrame mainFrame = new JFrame("Business Tire");
        mainFrame.setSize(800, 400);
        mainFrame.setLayout(new GridLayout(1, 1));
        jTextPane = new JTextPane();
        EmptyBorder eb = new EmptyBorder(new Insets(10, 10, 10, 10));
        jTextPane.setBorder(eb);
        DefaultCaret caret = (DefaultCaret) jTextPane.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        jTextPane.setSize(400, 400);
        Color c = new Color(0, 0, 0);
        jTextPane.setBackground(c);
        jTextPane.setFont(new Font("monospaced", Font.PLAIN, 17));
        JScrollPane jScrollPane = new JScrollPane(jTextPane);
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        mainFrame.add(jScrollPane);
        mainFrame.setVisible(true);
    }

    public void AddText(String text) throws BadLocationException {
        AddText(text, Color.WHITE);
    }

    public void AddText(String text, Color color) throws BadLocationException {
        StyledDocument doc = jTextPane.getStyledDocument();
        Style style = jTextPane.addStyle("White", null);
        StyleConstants.setForeground(style, color);
        doc.insertString(doc.getLength(), text + "\n", style);
    }

    public void SetText(String text) throws BadLocationException {
        jTextPane.setText("");
        StyledDocument doc = jTextPane.getStyledDocument();
        Style style = jTextPane.addStyle("White", null);
        StyleConstants.setForeground(style, Color.WHITE);
        doc.insertString(doc.getLength(), text, style);
    }

}
