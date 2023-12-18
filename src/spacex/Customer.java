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


    public String getName() {
        return name;
    }


    public String getType() {
        return type;
    }


    public String getCountry() {
        return country;
    }


    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Customer other){
            return name.equals(other.name) &&
                    type.equals(other.type) &&
                    country.equals(other.country);
        }
        return false;
    }

    public String toCSVFormat() {
        // Update with a display pattern discussed in design documentation
        return String.format("Name: %s, Type: %s, Country: %s", name, type, country);
    }

    public String toString(){
        String                  dashLine        = "********************************";
        StringBuilder           builder         = new StringBuilder(dashLine + "\n");
        DataMap[]               map             = new DataMap[3];

        map[0] = new DataMap("Name:  "           ,name);
        map[1] = new DataMap("Type:  "           ,type);
        map[2] = new DataMap("Country:  "        ,country);

        for(int i = 0 ; i < 3; i++) {
            builder.append(String.format("%-18s %-4s \n", map[i].name, map[i].value));
        }
        return builder.toString();
    }
}