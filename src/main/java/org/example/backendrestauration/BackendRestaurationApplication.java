package org.example.backendrestauration;

import lombok.AllArgsConstructor;
import org.example.backendrestauration.Service.IService;
import org.example.backendrestauration.Service.Iitem;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
@AllArgsConstructor
public class BackendRestaurationApplication implements CommandLineRunner {
    private Iitem iitem;
    private IService iService;
    private RepositoryRestConfiguration repositoryRestConfiguration;
    public static void main(String[] args) {
        SpringApplication.run(BackendRestaurationApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(org.example.backendrestauration.Entites.Menu.class);
        repositoryRestConfiguration.exposeIdsFor(org.example.backendrestauration.Entites.Item.class);

//       iService.InitializeMenu();
//        iService.InitializeDishe();
//        iService.InitializeIngredients();



    }
}
