/**
 * Classe para realizar configurações que adicionam recursos externos, tais como imagens
 * ou outros frameworks
 * @author Gabriel Porto Santos Peixoto
 */

package com.gabrielpeixoto.eFarm.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
    /**
     * Configura a aplicação para garantir acesso a recursos externos, neste caso,
     * os arquivos do Bootstrap e imagens estáticas.
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/webjars/**", "/resources/**")
                .addResourceLocations("/webjars/", "classpath:/resources/")
                .resourceChain(false);
    }

    @Override
    public void addCorsMappings(CorsRegistry registry)
    {
        registry.addMapping("/**").allowedOrigins("*");
    }
}
