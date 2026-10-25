import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Main {

    // ================= COLORS =================
    static final Color BG_TOP = new Color(225, 245, 255);
    static final Color BG_BOTTOM = new Color(245, 232, 255);

    static final Color BLUE = new Color(70, 150, 235);
    static final Color DARK_BLUE = new Color(45, 105, 180);
    static final Color PURPLE = new Color(145, 100, 220);
    static final Color PINK = new Color(235, 115, 175);

    static final Color WHITE = Color.WHITE;
    static final Color TEXT = new Color(45, 50, 65);
    static final Color LIGHT_TEXT = new Color(105, 110, 125);

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> createGUI());
    }

    // ================= MAIN GUI =================

    public static void createGUI() {

        JFrame frame = new JFrame("🧺 Laundry Hub - Operations Management");
        frame.setSize(900, 850);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // Main gradient background
        GradientPanel background =
                new GradientPanel(BG_TOP, BG_BOTTOM);

        background.setLayout(new BorderLayout());
        background.setBorder(new EmptyBorder(20, 25, 20, 25));

        // ================= HEADER =================

        JPanel header = new JPanel();
        header.setOpaque(false);
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));

        JLabel logo = new JLabel("🫧  🧺  LAUNDRY HUB  🧺  🫧");
        logo.setAlignmentX(Component.CENTER_ALIGNMENT);
        logo.setFont(new Font("Segoe UI Emoji", Font.BOLD, 30));
        logo.setForeground(DARK_BLUE);

        JLabel subtitle =
                new JLabel("Pickup • Clean • Track • Deliver ✨");
        subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        subtitle.setForeground(LIGHT_TEXT);

        header.add(logo);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);
        header.add(Box.createVerticalStrut(18));

        background.add(header, BorderLayout.NORTH);

        // ================= CONTENT =================

        JPanel content = new JPanel();
        content.setOpaque(false);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));

        // Customer Card
        RoundedPanel customerCard =
                new RoundedPanel(WHITE, 25);

        customerCard.setLayout(new GridBagLayout());
        customerCard.setBorder(
                new EmptyBorder(18, 25, 18, 25)
        );

        addSectionTitle(
                customerCard,
                "👤  CUSTOMER DETAILS",
                0
        );

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(8, 5, 8, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        JLabel nameLabel =
                createLabel("👤 Customer Name");

        JTextField nameField =
                createTextField("Enter your name");

        JLabel addressLabel =
                createLabel("📍 Address");

        JTextField addressField =
                createTextField("Enter pickup / delivery address");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.25;
        customerCard.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        customerCard.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.25;
        customerCard.add(addressLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        customerCard.add(addressField, gbc);

        content.add(customerCard);
        content.add(Box.createVerticalStrut(15));

        // ================= ORDER CARD =================

        RoundedPanel orderCard =
                new RoundedPanel(WHITE, 25);

        orderCard.setLayout(new GridBagLayout());
        orderCard.setBorder(
                new EmptyBorder(18, 25, 18, 25)
        );

        addSectionTitle(
                orderCard,
                "📦  ORDER DETAILS",
                0
        );

        JLabel orderIdLabel =
                createLabel("🆔 Order ID");

        JTextField orderIdField =
                createTextField("Example: 101");

        JLabel itemLabel =
                createLabel("👕 Number of Items");

        JTextField itemCountField =
                createTextField("Example: 3");

        JLabel weightLabel =
                createLabel("⚖️ Weights (kg)");

        JTextField weightField =
                createTextField("Example: 1.5, 2, 1");

        weightField.setToolTipText(
                "Enter weights separated by commas"
        );

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.25;
        orderCard.add(orderIdLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        orderCard.add(orderIdField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.25;
        orderCard.add(itemLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        orderCard.add(itemCountField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weightx = 0.25;
        orderCard.add(weightLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        orderCard.add(weightField, gbc);

        content.add(orderCard);
        content.add(Box.createVerticalStrut(15));

        // ================= SERVICE CARD =================

        RoundedPanel serviceCard =
                new RoundedPanel(WHITE, 25);

        serviceCard.setLayout(new GridBagLayout());
        serviceCard.setBorder(
                new EmptyBorder(18, 25, 18, 25)
        );

        addSectionTitle(
                serviceCard,
                "✨  CHOOSE YOUR SERVICE",
                0
        );

        JLabel serviceLabel =
                createLabel("🧼 Service Type");

        String[] services = {
                "🧺 Normal Laundry",
                "👔 Dry Cleaning",
                "👑 Premium Dry Cleaning"
        };

        JComboBox<String> serviceBox =
                new JComboBox<>(services);

        styleComboBox(serviceBox);

        JLabel deliveryLabel =
                createLabel("🚚 Delivery Option");

        String[] deliveryOptions = {
                "🏠 Home Delivery",
                "🏪 Self Collection"
        };

        JComboBox<String> deliveryBox =
                new JComboBox<>(deliveryOptions);

        styleComboBox(deliveryBox);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weightx = 0.25;
        serviceCard.add(serviceLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        serviceCard.add(serviceBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0.25;
        serviceCard.add(deliveryLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 0.75;
        serviceCard.add(deliveryBox, gbc);

        content.add(serviceCard);
        content.add(Box.createVerticalStrut(18));

        // ================= CREATE BUTTON =================

        RoundedButton createButton =
                new RoundedButton(
                        "✨  CREATE MY ORDER  ✨",
                        BLUE
                );

        createButton.setAlignmentX(
                Component.CENTER_ALIGNMENT
        );

        createButton.setFont(
                new Font("Segoe UI Emoji", Font.BOLD, 17)
        );

        createButton.setPreferredSize(
                new Dimension(300, 55)
        );

        createButton.setMaximumSize(
                new Dimension(350, 55)
        );

        content.add(createButton);
        content.add(Box.createVerticalStrut(18));

        // ================= RESULT CARD =================

        RoundedPanel resultCard =
                new RoundedPanel(
                        new Color(250, 250, 255),
                        25
                );

        resultCard.setLayout(
                new BorderLayout()
        );

        resultCard.setBorder(
                new EmptyBorder(15, 20, 15, 20)
        );

        JLabel resultTitle =
                new JLabel(
                        "📋  ORDER SUMMARY",
                        SwingConstants.CENTER
                );

        resultTitle.setFont(
                new Font("Segoe UI Emoji",
                        Font.BOLD, 20)
        );

        resultTitle.setForeground(PURPLE);

        JTextArea outputArea =
                new JTextArea();

        outputArea.setEditable(false);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);

        outputArea.setFont(
                new Font("Consolas",
                        Font.PLAIN, 14)
        );

        outputArea.setForeground(TEXT);
        outputArea.setBackground(
                new Color(248, 248, 253)
        );

        outputArea.setBorder(
                new EmptyBorder(15, 15, 15, 15)
        );

        JScrollPane scrollPane =
                new JScrollPane(outputArea);

        scrollPane.setBorder(null);

        resultCard.add(
                resultTitle,
                BorderLayout.NORTH
        );

        resultCard.add(
                scrollPane,
                BorderLayout.CENTER
        );

        resultCard.setPreferredSize(
                new Dimension(700, 230)
        );

        content.add(resultCard);

        // Scroll support
        JScrollPane mainScroll =
                new JScrollPane(content);

        mainScroll.setBorder(null);
        mainScroll.setOpaque(false);
        mainScroll.getViewport()
                .setOpaque(false);

        background.add(
                mainScroll,
                BorderLayout.CENTER
        );

        // ================= BUTTON ACTION =================

        createButton.addActionListener(e -> {

            try {

                String name =
                        nameField.getText().trim();

                String address =
                        addressField.getText().trim();

                if (name.isEmpty()
                        || address.isEmpty()) {

                    showError(
                            frame,
                            "Please enter customer details."
                    );

                    return;
                }

                int orderID =
                        Integer.parseInt(
                                orderIdField
                                        .getText()
                                        .trim()
                        );

                int itemCount =
                        Integer.parseInt(
                                itemCountField
                                        .getText()
                                        .trim()
                        );

                if (itemCount <= 0) {

                    showError(
                            frame,
                            "Number of items must be greater than 0."
                    );

                    return;
                }

                String[] weightValues =
                        weightField
                                .getText()
                                .split(",");

                if (weightValues.length
                        != itemCount) {

                    showError(
                            frame,
                            "Enter exactly "
                                    + itemCount
                                    + " weights separated by commas."
                    );

                    return;
                }

                double[] weights =
                        new double[itemCount];

                for (int i = 0;
                     i < itemCount;
                     i++) {

                    weights[i] =
                            Double.parseDouble(
                                    weightValues[i]
                                            .trim()
                            );

                    if (weights[i] <= 0) {

                        showError(
                                frame,
                                "Weight must be greater than 0."
                        );

                        return;
                    }
                }

                // Customer object
                Customer customer =
                        new Customer(
                                name,
                                address
                        );

                // Runtime polymorphism
                LaundryOrder order;

                int choice =
                        serviceBox
                                .getSelectedIndex();

                if (choice == 0) {

                    order =
                            new LaundryOrder(
                                    orderID,
                                    customer,
                                    itemCount,
                                    weights,
                                    "Normal"
                            );

                } else if (choice == 1) {

                    order =
                            new DryCleanOrder(
                                    orderID,
                                    customer,
                                    itemCount,
                                    weights
                            );

                } else {

                    order =
                            new PremiumDryCleanOrder(
                                    orderID,
                                    customer,
                                    itemCount,
                                    weights
                            );
                }

                // ================= DELIVERY =================

                Delivery delivery;

                int deliveryChoice =
                        deliveryBox
                                .getSelectedIndex();

                if (deliveryChoice == 0) {

                    delivery =
                            new PickupDelivery(
                                    address
                            );

                } else {

                    delivery =
                            new SelfCollect(
                                    "Laundry Service Center"
                            );
                }

                // ================= RESULT =================

                StringBuilder result =
                        new StringBuilder();

                result.append(
                        "🎉  ORDER CREATED SUCCESSFULLY!\n"
                );

                result.append(
                        "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n\n"
                );

                result.append(
                        "🆔 Order ID       : "
                ).append(order.getOrderID())
                        .append("\n");

                result.append(
                        "👤 Customer       : "
                ).append(customer.getName())
                        .append("\n");

                result.append(
                        "📍 Address        : "
                ).append(customer.getAddress())
                        .append("\n");

                result.append(
                        "👕 Items          : "
                ).append(order.getItemCount())
                        .append("\n");

                result.append(
                        "✨ Service        : "
                ).append(order.getServiceType())
                        .append("\n");

                result.append(
                        "⏱️ Turnaround     : "
                ).append(
                        order.calculateTurnaroundTime()
                ).append(" days\n");

                result.append(
                        "📦 Order Status   : "
                ).append(order.getStatus())
                        .append("\n");

                result.append(
                        "💰 TOTAL BILL     : ₹"
                ).append(
                        String.format(
                                "%.2f",
                                order.getTotalBill()
                        )
                ).append("\n\n");

                // Delivery
                delivery.deliver();

                result.append(
                        "🚚 Delivery Status: "
                ).append(
                        delivery.getDeliveryStatus()
                ).append("\n");

                result.append(
                        "\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━\n"
                );

                result.append(
                        "🫧 Thank you for choosing Laundry Hub! 🧺\n"
                );

                result.append(
                        "✨ Fresh clothes. Happy you. ✨"
                );

                // Display result
                outputArea.setText(
                        result.toString()
                );

                // Smooth visual effect
                animateResult(resultCard);

                JOptionPane.showMessageDialog(
                        frame,
                        "🎉 Your laundry order has been created!",
                        "Laundry Hub ✨",
                        JOptionPane.INFORMATION_MESSAGE
                );

            } catch (NumberFormatException ex) {

                showError(
                        frame,
                        "Please enter valid numbers.\n\n"
                                + "Example:\n"
                                + "Order ID: 101\n"
                                + "Items: 3\n"
                                + "Weights: 1.5, 2, 1"
                );

            } catch (Exception ex) {

                showError(
                        frame,
                        "Something went wrong:\n"
                                + ex.getMessage()
                );
            }
        });

        // ================= SHOW WINDOW =================

        frame.setContentPane(background);
        frame.setVisible(true);
    }

    // ================= HELPERS =================

    static JLabel createLabel(String text) {

        JLabel label =
                new JLabel(text);

        label.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        14
                )
        );

        label.setForeground(TEXT);

        return label;
    }

    static JTextField createTextField(
            String tooltip) {

        JTextField field =
                new JTextField();

        field.setFont(
                new Font(
                        "Segoe UI",
                        Font.PLAIN,
                        14
                )
        );

        field.setPreferredSize(
                new Dimension(300, 40)
        );

        field.setBorder(
                BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                                new Color(220, 220, 235),
                                1
                        ),
                        new EmptyBorder(
                                5, 12, 5, 12
                        )
                )
        );

        field.setToolTipText(tooltip);

        return field;
    }

    static void styleComboBox(
            JComboBox<String> box) {

        box.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.PLAIN,
                        14
                )
        );

        box.setPreferredSize(
                new Dimension(300, 40)
        );

        box.setBackground(Color.WHITE);
    }

    static void addSectionTitle(
            JPanel panel,
            String title,
            int row) {

        JLabel label =
                new JLabel(title);

        label.setFont(
                new Font(
                        "Segoe UI Emoji",
                        Font.BOLD,
                        18
                )
        );

        label.setForeground(PURPLE);

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = row;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets =
                new Insets(0, 0, 10, 0);

        panel.add(label, gbc);
    }

    static void showError(
            JFrame frame,
            String message) {

        JOptionPane.showMessageDialog(
                frame,
                message,
                "⚠️ Input Error",
                JOptionPane.ERROR_MESSAGE
        );
    }

    // ================= ANIMATION =================

    static void animateResult(
            JPanel panel) {

        Timer timer =
                new Timer(30, null);

        final int[] step = {0};

        timer.addActionListener(e -> {

            step[0]++;

            panel.setBorder(
                    new EmptyBorder(
                            Math.max(
                                    5,
                                    25 - step[0]
                            ),
                            20,
                            15,
                            20
                    )
            );

            panel.repaint();

            if (step[0] >= 20) {
                timer.stop();
            }
        });

        timer.start();
    }

    // ================= GRADIENT PANEL =================

    static class GradientPanel
            extends JPanel {

        private Color top;
        private Color bottom;

        GradientPanel(
                Color top,
                Color bottom) {

            this.top = top;
            this.bottom = bottom;
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            super.paintComponent(g);

            Graphics2D g2 =
                    (Graphics2D) g;

            int width = getWidth();
            int height = getHeight();

            GradientPaint gradient =
                    new GradientPaint(
                            0,
                            0,
                            top,
                            0,
                            height,
                            bottom
                    );

            g2.setPaint(gradient);

            g2.fillRect(
                    0,
                    0,
                    width,
                    height
            );
        }
    }

    // ================= ROUNDED PANEL =================

    static class RoundedPanel
            extends JPanel {

        private Color backgroundColor;
        private int radius;

        RoundedPanel(
                Color color,
                int radius) {

            this.backgroundColor = color;
            this.radius = radius;

            setOpaque(false);
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            // Shadow
            g2.setColor(
                    new Color(
                            0,
                            0,
                            0,
                            25
                    )
            );

            g2.fillRoundRect(
                    3,
                    4,
                    getWidth() - 6,
                    getHeight() - 6,
                    radius,
                    radius
            );

            // Main card
            g2.setColor(backgroundColor);

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth() - 7,
                    getHeight() - 7,
                    radius,
                    radius
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }

    // ================= ROUNDED BUTTON =================

    static class RoundedButton
            extends JButton {

        private Color normalColor;
        private Color hoverColor;

        RoundedButton(
                String text,
                Color color) {

            super(text);

            normalColor = color;

            hoverColor =
                    color.brighter();

            setForeground(Color.WHITE);

            setBackground(color);

            setFocusPainted(false);

            setBorderPainted(false);

            setContentAreaFilled(false);

            setOpaque(false);

            setCursor(
                    new Cursor(
                            Cursor.HAND_CURSOR
                    )
            );

            addMouseListener(
                    new MouseAdapter() {

                        @Override
                        public void mouseEntered(
                                MouseEvent e) {

                            setBackground(
                                    hoverColor
                            );

                            repaint();
                        }

                        @Override
                        public void mouseExited(
                                MouseEvent e) {

                            setBackground(
                                    normalColor
                            );

                            repaint();
                        }
                    }
            );
        }

        @Override
        protected void paintComponent(
                Graphics g) {

            Graphics2D g2 =
                    (Graphics2D) g.create();

            g2.setRenderingHint(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON
            );

            g2.setColor(getBackground());

            g2.fillRoundRect(
                    0,
                    0,
                    getWidth(),
                    getHeight(),
                    30,
                    30
            );

            g2.dispose();

            super.paintComponent(g);
        }
    }
}
