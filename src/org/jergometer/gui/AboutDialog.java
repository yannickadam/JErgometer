package org.jergometer.gui;

import org.jergometer.Jergometer;
import org.jergometer.translation.I18n;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;

public class AboutDialog extends JFrame {
	private JPanel contentPane;
	private JLabel credits;

	public AboutDialog() {
		super(I18n.getString("about_dialog.title"));
		setUndecorated(true);
		setSize(400, 400);
		// place window in the center of the screen
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension windowSize = getSize();
		setLocation(screenSize.width / 2 - (windowSize.width / 2), screenSize.height / 2 - (windowSize.height / 2));
		setContentPane(contentPane);
//		setModal(true);

		StringBuffer sb = new StringBuffer();
		sb.append(System.getProperty("java.vm.name")).append("<br>");
		sb.append(System.getProperty("java.vendor")).append("<br>");
		sb.append(System.getProperty("java.home"));
		String vmString = sb.toString();

		credits.setText(I18n.getString("about_dialog.text", Jergometer.version, System.getProperty("java.version"), vmString));

		pack();

		addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {
				onClick();
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseReleased(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}
		});

		addKeyListener(new KeyListener() {
			public void keyTyped(KeyEvent e) {
			}

			public void keyPressed(KeyEvent e) {
				onClick();
			}

			public void keyReleased(KeyEvent e) {
			}
		});

		addFocusListener(new FocusListener() {
			public void focusGained(FocusEvent e) {
			}

			public void focusLost(FocusEvent e) {
				onClick();
			}
		});
	}

	private void onClick() {
		dispose();
	}

	public void showMe() {
//		pack();
		setVisible(true);
	}

  {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
    $$$setupUI$$$();
  }

  /**
   * Method generated by IntelliJ IDEA GUI Designer
   * >>> IMPORTANT!! <<<
   * DO NOT edit this method OR call it in your code!
   *
   * @noinspection ALL
   */
  private void $$$setupUI$$$() {
    contentPane = new JPanel();
    contentPane.setLayout(new GridBagLayout());
    credits = new JLabel();
    credits.setHorizontalAlignment(2);
    credits.setHorizontalTextPosition(0);
    credits.setIcon(new ImageIcon(getClass().getResource("/org/jergometer/images/credits_logo.png")));
    this.$$$loadLabelText$$$(credits, ResourceBundle.getBundle("org/jergometer/translation/jergometer").getString("about_dialog.text"));
    GridBagConstraints gbc;
    gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    contentPane.add(credits, gbc);
  }

  /**
   * @noinspection ALL
   */
  private void $$$loadLabelText$$$(JLabel component, String text) {
    StringBuffer result = new StringBuffer();
    boolean haveMnemonic = false;
    char mnemonic = '\0';
    int mnemonicIndex = -1;
    for (int i = 0; i < text.length(); i++) {
      if (text.charAt(i) == '&') {
        i++;
        if (i == text.length()) break;
        if (!haveMnemonic && text.charAt(i) != '&') {
          haveMnemonic = true;
          mnemonic = text.charAt(i);
          mnemonicIndex = result.length();
        }
      }
      result.append(text.charAt(i));
    }
    component.setText(result.toString());
    if (haveMnemonic) {
      component.setDisplayedMnemonic(mnemonic);
      component.setDisplayedMnemonicIndex(mnemonicIndex);
    }
  }

  /**
   * @noinspection ALL
   */
  public JComponent $$$getRootComponent$$$() {
    return contentPane;
  }
}
