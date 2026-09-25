public class Intent {

    private String name;
    private String[] keywords;
    private String response;

    public Intent(String name, String[] keywords, String response) {
        this.name = name;
        this.keywords = keywords;
        this.response = response;
    }

    public String getName() {
        return name;
    }

    public String[] getKeywords() {
        return keywords;
    }

    public String getResponse() {
        return response;
    }
}