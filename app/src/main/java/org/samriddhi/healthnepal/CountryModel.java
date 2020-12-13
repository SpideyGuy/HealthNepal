package org.samriddhi.healthnepal;

class CountryModel {
    String countryFlag;
    String name;
    String population;
    String GDP;
    String independenceSince;

    public CountryModel(String countryFlag, String name, String population, String GDP, String independenceSince) {
        this.countryFlag = countryFlag;
        this.name = name;
        this.population = population;
        this.GDP = GDP;
        this.independenceSince = independenceSince;
    }

    public String getCountryFlag() {
        return countryFlag;
    }

    public void setCountryFlag(String countryFlag) {
        this.countryFlag = countryFlag;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getGDP() {
        return GDP;
    }

    public void setGDP(String GDP) {
        this.GDP = GDP;
    }

    public String getIndependenceSince() {
        return independenceSince;
    }

    public void setIndependenceSince(String independenceSince) {
        this.independenceSince = independenceSince;
    }
}
