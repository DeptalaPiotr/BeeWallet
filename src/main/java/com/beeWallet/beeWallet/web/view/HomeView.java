package com.beeWallet.beeWallet.web.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import jakarta.annotation.security.PermitAll;

import java.util.logging.Logger;

@Route(value = "")
@PageTitle("Home | BeeWallet")
@PermitAll
public class HomeView extends AppLayout {

    private static final Logger LOGGER = Logger.getLogger(HomeView.class.getName());

    public HomeView() {
        homeView();
    }

    public void homeView() {
        LOGGER.config("homeView()");
        H1 logo = new H1("BeeWallet");
        logo.addClassNames("text-l", "m-m");

        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.setDefaultVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.expand(logo);
        header.setSizeFull();
        header.addClassNames("py-0", "px-m");

        addToNavbar(header);
        LOGGER.config("homeView(...)");
    }

}