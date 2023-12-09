//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.*;
//import java.util.*;
//
//public class Main {
//    public static void main(String[] args) {
//        JFrame frame = new JFrame("Java Swing");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 400);
//
//        Layer layer = new Layer();
//        frame.add(layer);
//
//        frame.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                super.keyPressed(e);
//                if (e.getKeyChar() == 'c') {
//                    // Add a new circle with random position, velocity, and color
//                    int x = (int) (Math.random() * frame.getWidth());
//                    int y = (int) (Math.random() * frame.getHeight());
//                    int velocityX = (int) (Math.random() * 10) - 5;
//                    int velocityY = (int) (Math.random() * 10) - 5;
//                    int radius = (int) (Math.random() * 50) + 10;
//                    Color color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
//                    layer.addShape(new Circle(x, y, velocityX, velocityY, radius, color));
//                }
//            }
//        });
//
//        frame.setVisible(true);
//
//        // Animation thread
//        new Thread(() -> {
//            while (true) {
//                layer.moveShapes();
//                layer.checkCollisions();
//                layer.repaint();
//                try {
//                    Thread.sleep(1000 / 60);  // 60 FPS
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }).start();
//    }
//}
//
//class Layer extends JPanel {
//    private final ArrayList<Shape> shapes = new ArrayList<>();
//
//    public void addShape(Shape shape) {
//        shapes.add(shape);
//    }
//
//    public void moveShapes() {
//        for (Shape shape : shapes) {
//            shape.move();
//        }
//    }
//
//    public void checkCollisions() {
//        for (Shape shape : shapes) {
//            shape.checkCollision(getWidth(), getHeight());
//        }
//    }
//
//    @Override
//    public void paintComponent(Graphics g) {
//        super.paintComponent(g);
//        for (Shape shape : shapes) {
//            shape.draw(g);
//        }
//    }
//}
//
//abstract class Shape {
//    int x, y;
//    int velocityX, velocityY;
//    Color color;
//
//    public Shape(int x, int y, int velocityX, int velocityY, Color color) {
//        this.x = x;
//        this.y = y;
//        this.velocityX = velocityX;
//        this.velocityY = velocityY;
//        this.color = color;
//    }
//
//    public void move() {
//        x += velocityX;
//        y += velocityY;
//    }
//
//    public void checkCollision(int width, int height) {
//        if (x < 0 || x > width) {
//            velocityX *= -1;
//        }
//        if (y < 0 || y > height) {
//            velocityY *= -1;
//        }
//    }
//
//    public abstract void draw(Graphics g);
//}
//
//class Circle extends Shape {
//    int radius;
//
//    public Circle(int x, int y, int velocityX, int velocityY, int radius, Color color) {
//        super(x, y, velocityX, velocityY, color);
//        this.radius = radius;
//    }
//
//    @Override
//    public void draw(Graphics g) {
//        g.setColor(color);
//        g.fillOval(x, y, radius, radius);
//    }
//
//    @Override
//    public void checkCollision(int width, int height) {
//        if (x < 0 || x + radius > width) {
//            velocityX *= -1;
//        }
//        if (y < 0 || y + radius > height) {
//            velocityY *= -1;
//        }
//    }
//}
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Java Swing");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        Layer layer = new Layer();
        frame.add(layer);

        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyChar() == 'c') {
                    // Add a new circle with random position, velocity, and color
                    int x = (int) (Math.random() * frame.getWidth());
                    int y = (int) (Math.random() * frame.getHeight());
                    int velocityX = (int) (Math.random() * 10) - 5;
                    int velocityY = (int) (Math.random() * 10) - 5;
                    int radius = (int) (Math.random() * 50) + 10;
                    Color color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
                    layer.addShape(new Circle(x, y, velocityX, velocityY, radius, color));
                }
                if (e.getKeyChar() == 'r') {
                    // Add a new rectangle with random position, velocity, and color
                    int x = (int) (Math.random() * frame.getWidth());
                    int y = (int) (Math.random() * frame.getHeight());
                    int velocityX = (int) (Math.random() * 10) - 5;
                    int velocityY = (int) (Math.random() * 10) - 5;
                    int width = (int) (Math.random() * 50) + 10;
                    int height = (int) (Math.random() * 50) + 10;
                    Color color = new Color((float) Math.random(), (float) Math.random(), (float) Math.random());
                    layer.addShape(new Rectangle(x, y, velocityX, velocityY, width, height, color));
                }
            }
        });

        frame.setVisible(true);

        // Animation thread
        new Thread(() -> {
            while (true) {
                layer.moveShapes();
                layer.checkCollisions();
                layer.repaint();
                try {
                    Thread.sleep(1000 / 60);  // 60 FPS
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

class Layer extends JPanel {
    private final ArrayList<Shape> shapes = new ArrayList<>();

    public void addShape(Shape shape) {
        shapes.add(shape);
    }

    public void moveShapes() {
        for (Shape shape : shapes) {
            shape.move();
        }
    }

    public void checkCollisions() {
        for (Shape shape : shapes) {
            shape.checkCollision(getWidth(), getHeight());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Shape shape : shapes) {
            shape.draw(g);
        }
    }
}

abstract class Shape {
    int x, y;
    int velocityX, velocityY;
    Color color;

    public Shape(int x, int y, int velocityX, int velocityY, Color color) {
        this.x = x;
        this.y = y;
        this.velocityX = velocityX;
        this.velocityY = velocityY;
        this.color = color;
    }

    public void move() {
        x += velocityX;
        y += velocityY;
    }

    public abstract void checkCollision(int width, int height);

    public abstract void draw(Graphics g);
}

class Circle extends Shape {
    int radius;

    public Circle(int x, int y, int velocityX, int velocityY, int radius, Color color) {
        super(x, y, velocityX, velocityY, color);
        this.radius = radius;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x, y, radius, radius);
    }

    @Override
    public void checkCollision(int width, int height) {
        if (x < 0 || x + radius > width) {
            velocityX *= -1;
        }
        if (y < 0 || y + radius > height) {
            velocityY *= -1;
        }
    }
}

class Rectangle extends Shape {
    int width, height;

    public Rectangle(int x, int y, int velocityX, int velocityY, int width, int height, Color color) {
        super(x, y, velocityX, velocityY, color);
        this.width = width;
        this.height = height;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    @Override
    public void checkCollision(int frameWidth, int frameHeight) {
        if (x < 0 || x + width > frameWidth) {
            velocityX *= -1;
        }
        if (y < 0 || y + height > frameHeight) {
            velocityY *= -1;
        }
    }
}
