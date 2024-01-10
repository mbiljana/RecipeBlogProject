package rs.ac.uns.acs.smpuos.RecipeService.dto;

public class SearchRecipeDTO {

    private String name;

    public SearchRecipeDTO() {
    }

    public SearchRecipeDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
