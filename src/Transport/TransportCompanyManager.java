package Transport;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TransportCompanyManager {
    private List<TransportCompany> companies;

    public TransportCompanyManager() {
        companies = new ArrayList<>();
    }

    public void addCompany(TransportCompany company) {
        companies.add(company);
    }

    public void deleteCompany(TransportCompany company) {
        companies.remove(company);
    }

    public List<TransportCompany> getCompanies() {
        return companies;
    }

    public void editCompany(TransportCompany company) {
        int index = companies.indexOf(company);
        if (index >= 0) {
            companies.set(index, company);
        }
    }

    public void sortCompanies() {
        companies = companies.stream()
            .sorted((a, b) -> {
                int result = a.getName().compareTo(b.getName());
                if (result == 0) {
                    result = Double.compare(a.getFunds(), b.getFunds());
                }
                return result;
            })
            .collect(Collectors.toList());
    }
}