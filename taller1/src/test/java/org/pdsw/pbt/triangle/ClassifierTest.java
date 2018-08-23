package org.pdsw.pbt.triangle;

import org.junit.Test;
import org.pdsw.pbt.PBTClassifier;
import static org.quicktheories.QuickTheory.qt;
import static org.quicktheories.generators.SourceDSL.*;

public class ClassifierTest {

    @Test
    public void clasificaCorrectamenteUnTriangulo(){
      Classifier classifier = new Classifier();
      PBTClassifier pbtClassifier = new PBTClassifier("first Test");

      qt()
      .forAll(integers().between(-1, 20)
             , integers().between(-1, 20)
             , integers().between(-1, 20))
      .check((a,b,c) -> {
            TriangleType classification = classifier.classify(a, b, c);
            if (a <= 0) {
                pbtClassifier.collect("Not a triangle"); 
                pbtClassifier.describe();
                return classification == TriangleType.NotATriangle;
            } else if (b <= 0) {
                pbtClassifier.collect("Not a triangle");              
                return classification == TriangleType.NotATriangle;
            } else if (c <= 0){
                pbtClassifier.collect("Not a triangle");              
                return classification == TriangleType.NotATriangle;
            }            
            else if(a+b<c || a+c<b || c+b<a){
                pbtClassifier.collect("Not a triangle");              
                return classification == TriangleType.NotATriangle;
            }
            else if(a==b && b==c){
                pbtClassifier.collect("Es un triángulo equilátero");              
                return classification == TriangleType.Equilateral;
            }
            else if(a==b){
                pbtClassifier.collect("Es un triángulo isoscel");              
                return classification == TriangleType.Isosceles;
            }
            else if(a==c){
                pbtClassifier.collect("Es un triángulo isoscel");              
                return classification == TriangleType.Isosceles;
            }
            else if(b==c){
                pbtClassifier.collect("Es un triángulo isoscel");              
                return classification == TriangleType.Isosceles;
            }
            else{
                pbtClassifier.collect("Es un triángulo escaleno");              
                return classification == TriangleType.Scalene;
            }
          }); 
      pbtClassifier.results();
  }
}
