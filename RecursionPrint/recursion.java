 class practical8{
    public static void main(String args[]){
      practical8 obj=new practical8();
      obj.printPt1(3,1);
      System.out.println();
      obj.printPt2(3,1);
      System.out.println();
      obj.printPt3(5);
      System.out.println();
      obj.displayPattern(3,1);
    }
    //question 1
    void printPt1(int size,int ln){
      if(ln<size+1){
        printStar1(ln,1);
        System.out.println();
        printPt1(size,ln+1);
        printStar1(ln,1);
        System.out.println();
      }
      if(ln==size+1){
        printStar1(ln,1); 
        System.out.println();
      }
    }
    void printStar1(int ln,int pt){
      if(pt<=ln){
        System.out.print("*");
        printStar1(ln,pt+1);
      }
    }
    //question 2
    void printPt2(int size,int ln){
      if(ln<size+1){
        printSpace2(size,ln);
        printStar2(ln,1,"*");
        System.out.println();
        printPt2(size,ln+1);
        printSpace2(size,ln);
        printStar2(ln,1,"/");
        System.out.println();
      }
      if(ln==size+1){
        printStar2(ln,1,"+"); 
        System.out.println();
      }
    }
    void printStar2(int ln,int pt,String pt1){
      if(pt<=ln){
        System.out.print(pt1);
        printStar2(ln,pt+1,pt1);
      }
    }
    void printSpace2(int size,int ln){
      if(ln<=size){
        System.out.print(" ");
        printSpace2(size,ln+1);
      }
    }
    //question 3
    void printPt3(int size){
      displayPt3(size,1);
      displayPlus3(size,1);
    }
    void displayPt3(int size,int ln){
      if(size%2==1){
        if(ln==size/2+1){
          printStar3(ln,1); 
          System.out.println();
        }else if(ln<=(size/2)+1){
          printSpace3(size,ln);
          printStar3(ln,1);
          System.out.println();
          displayPt3(size,ln+1);
          printSpace3(size,ln);
          printStar3(ln,1);
          System.out.println();      
        } 
      }else{
        if(ln<(size/2)+1){
          printSpace3(size,ln);
          printStar3(ln,1);
          System.out.println();
          displayPt3(size,ln+1);
          printSpace3(size,ln);
          printStar3(ln,1);
          System.out.println();      
        } 
      }
    }
    void printStar3(int ln,int pt){
      if(pt<=(2*ln)-1){
        System.out.print("*");
        printStar3(ln,pt+1);
      }
    }
    void printSpace3(int size,int ln){
      if(ln<=size/2){
        System.out.print(" ");
        printSpace3(size,ln+1);
      }
    }
    void displayPlus3(int size,int ln){
      if(ln<=size){
        showPt3(size,1);
        displayPlus3(size,ln+1);
      }
    }
    void showPt3(int size,int space){
      if(space<size/2+1){
        System.out.print(" ");
        showPt3(size,space+1);
      }else if(space==size/2+1){
        System.out.print("+");
        System.out.println();
      }
    }
    
    //question 4 extra
    void displayPattern(int size,int ln){
      if(ln<=size+1){
        printSpace(size,ln);
        printPt(ln,1);
        System.out.println();
        displayPattern(size,ln+1);
        printSpace(size,ln);
        printPt4(ln,1);
        System.out.println();
      }
    }
    void printSpace(int size,int ln){
      if(ln<=size){
        System.out.print(" ");
        printSpace(size,ln+1);
      }
    }
    void printPt(int ln,int pt){
      if(pt<=2*ln-1){
        if(ln%2==1){
          System.out.print("*");
          printPt(ln,pt+1);
        }else{
          System.out.print("/");
          printPt(ln,pt+1);
        }
      }
    }
    void printPt4(int ln,int pt){
      if(pt<=2*ln-1){
        if(ln%2==1){
          System.out.print("/");
          printPt4(ln,pt+1);
        }else{
          System.out.print("*");
          printPt4(ln,pt+1);
        }
      }
    }
  }