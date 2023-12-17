package spacex;
public class Customer {
    //data fields
    private String name;
    private String type;
    private String country;

    public Customer(){
        this("", "", "");
    }
    public Customer(String name, String type, String country) {
        this.name     = name;
        this.type     = type;
        this.country  = country;
    }
    //TODO: Generate an equals method
    @Override
    public boolean equals(Object obj)
    {
        if(obj instanceof Customer other){
            return name.equals(other.name) &&
                    type.equals(other.type) &&
                    country.equals(other.country);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getCountry() {
        return country;
    }


    public String toString() {
        // Update with a display pattern discussed in design documentation
        return String.format("Name: %s, Type: %s, Country: %s", name, type, country);
    }
}