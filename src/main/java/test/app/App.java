package test.app;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        String regex = "\\d+";

     // positive test cases, should all be "true"
     System.out.println("1".matches(regex));
     System.out.println("134d3".matches(regex));
     System.out.println("1343".matches(regex));
     System.out.println("0343".matches(regex));
        
    }
}
