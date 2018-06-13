/*
 * The MIT License
 *
 * Copyright 2018 Fibo.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package graphicuserinterface;

import atomicgraphics.Matrix3D;
import atomicgraphics.Triangle;
import atomicgraphics.Vertex;
import java.awt.*;
import java.awt.geom.Path2D;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author Fibo
 */
public class ViewerFrame {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Container pane = frame.getContentPane();
        pane.setLayout(new BorderLayout());
        
        JSlider headingSlider = new JSlider(0, 360, 180);
        pane.add(headingSlider, BorderLayout.SOUTH);
        
        JSlider pitchSlider = new JSlider(SwingConstants.VERTICAL, -90, 90, 0);
        pane.add(pitchSlider, BorderLayout.EAST);
        
        JPanel renderPanel = new JPanel() {
            public void paintCompenent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setColor(Color.BLACK);
                g2.fillRect(0, 0, getWidth(), getHeight());
                double heading = Math.toRadians(headingSlider.getValue());
                Matrix3D transform = new Matrix3D(new double[] {
                    Math.cos(heading), 0, -Math.sin(heading),
                    0, 1, 0,
                    Math.sin(heading), 0, -Math.cos(heading)
                });
                List<Triangle> triangles = new ArrayList<>();
               
                triangles.add(new Triangle(new Vertex(100, 100, 100),
                                           new Vertex(-100, -100, 100),
                                           new Vertex(-100, 100, -100),
                                           Color.WHITE));
                triangles.add(new Triangle(new Vertex(100, 100, 100),
                                           new Vertex(-100, -100, 100),
                                           new Vertex(100, -100, -100),
                                           Color.RED));
                triangles.add(new Triangle(new Vertex(-100, 100, -100),
                                           new Vertex(100, -100, -100),
                                           new Vertex(100, 100, 100),
                                           Color.GREEN));
                triangles.add(new Triangle(new Vertex(-100, 100, -100),
                                           new Vertex(100, -100, -100),
                                           new Vertex(-100, -100, 100),
                                           Color.BLUE));
                g2.translate(getWidth() / 2, getHeight() / 2);
                g2.setColor(Color.WHITE);
                for (Triangle triangle : triangles) {
                    Vertex firstVertex = transform.transform(triangle.getFirstVertex());
                    Vertex secondVertex = transform.transform(triangle.getSecondVertex());
                    Vertex thirdVertex = transform.transform(triangle.getThirdVertex());
                    Path2D path = new Path2D.Double();
                    path.moveTo(firstVertex.getX(), firstVertex.getY());
                    path.lineTo(secondVertex.getX(), secondVertex.getY());
                    path.lineTo(thirdVertex.getX(), thirdVertex.getY());
                    path.closePath();
                    g2.draw(path);
                }
            }
        };
        pane.add(renderPanel, BorderLayout.CENTER);
        
        headingSlider.addChangeListener((event) -> renderPanel.repaint());
        pitchSlider.addChangeListener((event) -> renderPanel.repaint());
        
        frame.setSize(1920, 1080);
        frame.setVisible(true);
    }
}
