/**
 * Java. Chatter: simple chatbot
 *
 *
 * @author Sergey Iryupin
 * @change Volsky Nikita 07.01.2018 (Add logging)
 * @version 0.2.3 dated Jun 17, 2017
 */

import bot.SimpleBot;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.*;

class SimpleChatBot extends JFrame implements ActionListener {

    final String TITLE_OF_PROGRAM = "Chatter: simple chatbot";
    final int START_LOCATION = 200;
    final int WINDOW_WIDTH = 350;
    final int WINDOW_HEIGHT = 450;
    final String CHB_AI = "AI";
    final String BTN_ENTER = "Enter";

    JTextArea dialogue; // area for dialog
    JCheckBox ai;       // enable/disable AI
    JTextField message; // field for entering messages
    SimpleBot sbot;     // chat-bot class (in bot package)
    SimpleAttributeSet botStyle; // style bot text

    private static FileHandler handler = null;
    private static Logger logger = null;

    /**
     * Метод инициации логера
     */
    public static void initLogger() {
        try {
            // Создаем файл и передаем ему параметр, что только на добавление
            handler = new FileHandler("chat.log", true);
            // Если не установить формат, то лог будет в виде xml
            handler.setFormatter(new SimpleFormatter());
            // не смог разобраться зачем, но без этого не работает, причем разная подстановка значения не меняет работу приложения
            logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
            // Подключаем файл к логу
            logger.addHandler(handler);
            // Также можно указать, какого размера может быть лог
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void addLog(String msg){
        logger.info(msg);
    }

    public static void main(String[] args) {
        initLogger();
        new SimpleChatBot();
    }

    /**
     * Constructor:
     * Creating a window and all the necessary elements on it
     */
    SimpleChatBot() {
        setTitle(TITLE_OF_PROGRAM);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(START_LOCATION, START_LOCATION, WINDOW_WIDTH, WINDOW_HEIGHT);
        // area for dialog
        dialogue = new JTextArea();
        dialogue.setEditable(false);
        JScrollPane scrollBar = new JScrollPane(dialogue);
        // panel for checkbox, message field and button
        JPanel bp = new JPanel();
        bp.setLayout(new BoxLayout(bp, BoxLayout.X_AXIS));
        ai = new JCheckBox(CHB_AI);
        ai.doClick();
        message = new JTextField();
        message.addActionListener(this);
        JButton enter = new JButton(BTN_ENTER);
        enter.addActionListener(this);
        // adding all elements to the window
        bp.add(ai);
        bp.add(message);
        bp.add(enter);
        add(BorderLayout.CENTER, scrollBar);
        add(BorderLayout.SOUTH, bp);
        setVisible(true);
        sbot = new SimpleBot(); // creating bot object
    }

    /**
     * Listener of events from message field and enter button
     */
    @Override
    public void actionPerformed(ActionEvent event) {
        if (message.getText().trim().length() > 0) {
            try {
                Document doc = dialogue.getDocument();
                // Формируем сообщение
                String msg = message.getText() + "\n" +
                        TITLE_OF_PROGRAM.substring(0, 9) +
                        sbot.sayInReturn(message.getText(), ai.isSelected()) + "\n";
                // Добавляем сообщение на TextArea
                doc.insertString(doc.getLength(), msg, null);
                // Добавляем сообщение в лог
                addLog(msg);
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
        message.setText("");
        message.requestFocusInWindow();
    }
}