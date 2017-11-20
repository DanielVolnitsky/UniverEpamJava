package tasks.task4_16_11_2017.entities;

public class LocationInfo {

    private String countryName;
    private String city;
    private String latitude;
    private String longitude;

    public LocationInfo(){

    }

    public LocationInfo(String countryName, String city, String latitude, String longitude) {
        this.countryName = countryName;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "LocationInfo{" +
                "countryName='" + countryName + '\'' +
                ", city='" + city + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
