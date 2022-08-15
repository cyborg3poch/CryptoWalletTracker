package xyz.epoch.wallettracker.Config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitialiser extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class [] arr   = {AppConfig.class};
        return  arr ;
    }

    @Override
    protected String[] getServletMappings() {
        String [] arr = {"/"};
        return  arr ;
    }
}
