package com.compozent_internship;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DigitalClock extends JFrame {

	private JLabel timeLabel;
	private JLabel dateLabel;
	private Timer timer;

	public DigitalClock() {
		// Set up the JFrame
		setTitle("Digital Clock");
		setSize(300, 150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); // Centered with 10-pixel horizontal and vertical gap

		// Create time label
		timeLabel = new JLabel("", JLabel.CENTER);
		timeLabel.setFont(new Font("Segoe UI", Font.BOLD, 30));
		timeLabel.setForeground(new Color(34, 49, 63)); // Set text color
		add(timeLabel);

		// Create date label
		dateLabel = new JLabel("", JLabel.CENTER);
		dateLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		dateLabel.setForeground(new Color(34, 49, 63)); // Set text color
		add(dateLabel);

		// Set up timer to update time and date every second
		timer = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateTimeAndDate();
			}
		});
		timer.start();
	}

	private void updateTimeAndDate() {
		// Get current time
		SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm:ss a");
		String currentTime = timeFormat.format(new Date());

		// Convert "am" and "pm" to uppercase
		currentTime = currentTime.replace("am", "AM").replace("pm", "PM");

		// Get current date
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE, MMM d, yyyy");
		String currentDate = dateFormat.format(new Date());

		// Update labels
		timeLabel.setText(currentTime);
		dateLabel.setText(currentDate);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				DigitalClock clock = new DigitalClock();
				clock.setLocationRelativeTo(null); // Center the frame on the screen
				clock.setVisible(true);
			}
		});
	}
}
