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
package atomicgraphics;

import java.awt.Color;

/**
 *
 * @author Fibo
 */
public class Triangle {
    
    private Vertex firstVertex;
    
    private Vertex secondVertex;
    
    private Vertex thirdVertex;
    
    private Color color;
    
    public Triangle(Vertex firstVertex, Vertex secondVertex, 
            Vertex thirdVertex, Color color) {
        this.firstVertex = firstVertex;
        this.secondVertex = secondVertex;
        this.thirdVertex = thirdVertex;
        this.color = color;
    }
    
    public Vertex getFirstVertex() {
        return firstVertex;
    }
    
    public Vertex getSecondVertex() {
        return secondVertex;
    }
    
    public Vertex getThirdVertex() {
        return thirdVertex;
    }
    
    public Color getColor() {
        return color;
    }
}
