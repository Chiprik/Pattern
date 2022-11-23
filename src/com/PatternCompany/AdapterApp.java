package com.PatternCompany;

import java.io.FileNotFoundException;

public class AdapterApp {
    public static void main(String[] args) throws FileNotFoundException {
        //1-й способ через наследавание
        VectorGraphicsInterface g1 = new VectorAdapterFromRaster();
        g1.drawSquare();
        g1.drawLine();
        //2-й способ через композицию
        VectorGraphicsInterface g2 = new VectorAdapterFromRaster2();
        g2.drawSquare();
        g2.drawLine();
    }
}
interface VectorGraphicsInterface{
    void drawLine();
    void drawSquare();
}
class RasterGraphics{
    void drawRasterLine(){
        System.out.println("Рисуем линию");
    }
    void drawRasterSquare(){
        System.out.println("Рисуем квадрат");
    }
}
class VectorAdapterFromRaster extends RasterGraphics implements VectorGraphicsInterface{
    public void drawLine(){
        drawRasterLine();
    }
    public void drawSquare(){
        drawRasterSquare();
    }
}
class VectorAdapterFromRaster2 implements VectorGraphicsInterface{
    RasterGraphics raster = new RasterGraphics();
    public void drawLine() {
        raster.drawRasterLine();
    }
    public void drawSquare() {
        raster.drawRasterSquare();
    }
}