package Sheet3;

public class MyStringBuffer {
    private char [] string;

    public MyStringBuffer(String string){
        this.string = string.toCharArray();
    }
    public MyStringBuffer(){
        this("");
    }

    public void print(){
        for(char c: this.string)
            System.out.print(c); // using print to avoid the newline in println
        System.out.println();    // to print new line after printing the stirng
    }

    public int indexOf(char c){
        for(int i = 0 ; i < this.string.length; i++)
            if (this.string[i] == c)
                return i;

        // if the char is not existed in the string
        return -1;
    }

    public int length(){
        return this.string.length;
    }


    public void erase(int start, int length){
    String newString = "";
    // get the string after erase a substring by copying only the chars outside the range of erase
    for(int i = 0; i < this.string.length; i++){
        if (i >= start && i < start+length)
            continue;
        else
            newString += this.string[i];
    }
    this.string = newString.toCharArray();
    }


    public void insert(int start, String string){
        String newString = "";
        int loopLen = this.string.length + string.length();

        // copy the this.string into the newString until we reach to the insertion point of the new string
        // copy the given string and then continue with this.string
        int thisStringCounter = 0;
        int givenStringCounter = 0;
        for(int i = 0 ; i < loopLen ; i++){
            if (i >= start && i < start+string.length())
                    newString += string.charAt(givenStringCounter++);
            else
                newString += this.string[thisStringCounter++];
        }
        this.string = newString.toCharArray();
    }
}
