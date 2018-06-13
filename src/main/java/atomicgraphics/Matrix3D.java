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

/**
 *
 * @author Fibo
 */
public class Matrix3D {
    
    private double[] values;
    
    public Matrix3D(double[] values) {
        this.values = values;
    }
    
    public double[] getValues() {
        return values;
    }
    
    public Matrix3D multiply(Matrix3D other) {
        double[] result = new double[9];
        for (int line = 0; line < 3; line++) {
            for (int column = 0; column < 3; column++) {
                for (int inter = 0; inter < 3; inter++) {
                    result[line * 3 + column] += this.values[line * 3 + inter]
                            * other.getValues()[inter * 3 + column];
                }
            }
        }
        return new Matrix3D(result);
    }
    
    public Vertex transform(Vertex in) {
        return new Vertex(
            in.getX() * values[0] + in.getY() * values[1] + in.getZ() * values[2],
            in.getX() * values[3] + in.getY() * values[4] + in.getZ() * values[5],
            in.getX() * values[6] + in.getY() * values[7] + in.getZ() * values[8]);
    }
}
