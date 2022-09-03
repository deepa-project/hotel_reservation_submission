//Ref for regex evaluation of email
//https://www.w3schools.com/java/tryjava.asp?filename=demo_regex
package model;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Customer {
    private  String firstName;
    private  String lastName;
    private  String email = new String();
    
    public Customer(String fn,String ln, String em) {

            this.firstName=fn;
            this.lastName=ln;
            final String PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(PATTERN, Pattern.CASE_INSENSITIVE);
        //Source:https://stackoverflow.com/questions/8204680/java-regex-email
            Matcher matcher = pattern.matcher(em);
            boolean matchFound = matcher.find();
        System.out.println("From constructor: Matches pattern?: "+pattern.matcher(em));
        if(matcher.matches()) {
            //System.out.println("Email format is correct!!!*****");
            this.email=em;
        } else {
            System.out.println("Email pattern not found");
            this.firstName="";
            this.lastName="";
            this.email="";


        }
    }




    public void setFirstName(String fn)
{
    this.firstName=fn;
}
public void setLastName(String ln)
{
    this.lastName=ln;
}
public void setEmail(String em)
{
    final String PATTERN = "^[A-Za-z0-9+_.-]+@(.+)$";

    Pattern pattern = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$", Pattern.CASE_INSENSITIVE);

    Matcher matcher = pattern.matcher(em);
    boolean matchFound = matcher.find();
    //System.out.println("Matches pattern?: "+pattern.matcher(em));
    if(matchFound){
        //System.out.println("Email format is correct!!!*****");
        this.email=em;
    } else {

        System.out.println("Email pattern not found");
    }


}
public String getFirstName()
{
    return this.firstName;
}
public String getLastName()
{
    return this.lastName;
}
public String getEmail() {

    return this.email;
}

    @Override
    public String toString() {
        return (this.firstName+" "+this.lastName+" "+this.email);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getFirstName().equals(customer.getFirstName()) && getLastName().equals(customer.getLastName()) && getEmail().equals(customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirstName(), getLastName(), getEmail());
    }
}
