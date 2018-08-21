package org.pdsw.pbt.triangle;

public class Classifier {
    public TriangleType classify(int x, int y, int z) {
        TriangleType tipo;
        if(desigualdadTriangular(x,y,z) != false){
            if (x==y && x==z){
                tipo = TriangleType.Equilateral;
            }
            else if(x==y || x==z || z==y){
                tipo = TriangleType.Isosceles;
            }
            else{
                tipo = TriangleType.Scalene;
            }
        }
        else{
            tipo = TriangleType.NotATriangle;
        }
        return tipo;
    }
    
    public boolean desigualdadTriangular(int x, int y, int z) {
        boolean esTriangulo;
        if(x>0 && y>0 && z>0){
            if(x+y<z || x+z<y || z+y<x){
                esTriangulo = false;
            }else{
                esTriangulo = true;
            }
        }
        else {
            esTriangulo = false;
        }
        return esTriangulo;
    }
}
