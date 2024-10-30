package pro.vasudevan.pages;

import org.openqa.selenium.WebElement;
import pro.vasudevan.automation.unifiedtestframework.base.ElementBase;

import java.util.*;
import java.util.function.Supplier;

/*
Created By: Vasudevan Sampath

HomePage.java uses Selenium Page Object Model (POM) with all element defs and methods for Home Page
*/
public final class HomePage extends ElementBase implements IBasePage {

    private final Supplier<Boolean> bag = () -> findElements("topLevelBag").size() == 1;
    private final Supplier<Boolean> topLevelResources = () -> findElements("topLevelLinksParent").size() == 11;
    private final Supplier<List<WebElement>> topLevelLinks = () -> findElements("topLevelLinksParent");
    private final Supplier<Boolean> globalNavLinks = () -> findElements("globalNavLinks").size() == 2;
    private final Supplier<List<WebElement>> productLinkImages = () -> findElements("productLinkImages");
    private final Supplier<List<WebElement>> productLinkText = () -> findElements("productLinks");

    public boolean didBagExist() {return bag.get();}

    public boolean didTopLevelResourcesExist() {return topLevelResources.get();}

    public boolean didGlobalNavLinksExist() {return globalNavLinks.get();}

    public boolean didProductLinksExist() {return productLinkImages.get().size() == 11;}

    private boolean compare(List<WebElement> links, LinkedHashMap<String, String> linkedHashMap) {
        List<String> actual = links.stream()
                .map(element -> element.getText().trim())
                .toList();
        System.out.println("Actual: " + actual);
        List<String> expected = linkedHashMap.values().stream().toList();
        System.out.println("Expected: " + expected);
        return actual.equals(expected);
    }

    public boolean areTopLevelLinksAvailable(LinkedHashMap<String, String> linkedHashMap) {
        return compare(topLevelLinks.get(), linkedHashMap);
    }

    public boolean areProductLinksAvailable(LinkedHashMap<String, String> linkedHashMap) {
        return compare(productLinkText.get(), linkedHashMap);
    }

    public boolean areImagesIdentical() throws Exception {
        return IBasePage.areImagesIdentical(1, productLinkImages);
    }
}
