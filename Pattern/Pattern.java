class practical6{
void displayPattern1(int size){

//Upper Part
for(int line=1;line<=size;line++){
for(int spaces=1;spaces<=size-line;spaces++){
System.out.print(" ");
}
for(int plus=1;plus<=2*line-1;plus++){
if(plus%2==0){
System.out.print(" ");
}else{
System.out.print("+");
}
}
System.out.println();
}

//Lower Part

for(int line=size-1;line>=1;line--){
for(int spaces=1;spaces<=size-line;spaces++){
System.out.print(" ");
}
for(int star=1;star<=2*line-1;star++){
if(star%2==0){
System.out.print(" ");
}else{
System.out.print("*");
}

}
System.out.println();
}

}


---------------------------------------------------------------
void displayPattern2(int size){

//Upper Part
for(int line=1;line<=size;line++){
for(int spaces=1;spaces<=size-line;spaces++){
System.out.print(" ");
}
for(int plus=1;plus<=2*line-1;plus++){
System.out.print("+");
}
System.out.println();
}

//Lower Part
for(int line=size-1;line>=1;line--){
for(int spaces=1;spaces<=size-line;spaces++){
System.out.print(" ");
}
for(int plus=1;plus<=2*line-1;plus++){
System.out.print("+");
}
System.out.println();
}

}

----------------------------------------------------------

void displayPattern3(int size){

//Upper Part
for(int line=1;line<=size;line++){
for(int spaces=1;spaces<=size-line;spaces++){
System.out.print(" ");
}
for(int character=1;character<=2*line-1;character++){
if((line+character)%2==0){
System.out.print("+");
}else{
System.out.print("*");
}
}
System.out.println();
}

//Lower Part

for(int line=size;line>=1;line--){
for(int spaces=1;spaces<=size-line;spaces++){
System.out.print(" ");
}
for(int character=1;character<=2*line-1;character++){
if((line+character)%2==0){
System.out.print("*");
}else{
System.out.print("+");
}

}
System.out.println();
}

}

}