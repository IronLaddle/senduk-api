/*
 * package net.sendukbesi.springbootrest.toilet;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.ApplicationListener; import
 * org.springframework.context.event.ContextRefreshedEvent; import
 * org.springframework.stereotype.Component;
 * 
 * @Component public class ApreloadData implements
 * ApplicationListener<ContextRefreshedEvent> {
 * 
 * 
 * private RepoToilet toiletRepository;
 * 
 * private RepoToiletUser toiletUserRepository;
 * 
 * @Autowired public void setToiletRepository(RepoToilet toiletRepository) {
 * this.toiletRepository = toiletRepository; }
 * 
 * @Autowired public void setToiletUserRepository(RepoToiletUser
 * toiletUserRepository) { this.toiletUserRepository = toiletUserRepository; }
 * 
 * @Override public void onApplicationEvent(ContextRefreshedEvent arg0) {
 * 
 * ModelToilet toilet = new ModelToilet(); ModelToilet toilet1 = new
 * ModelToilet(); ModelToilet toilet2 = new ModelToilet();
 * 
 * ModelToiletUser toiletUser = new ModelToiletUser();
 * 
 * if(toiletRepository.findByName("Tandas Klia 1") == null) {
 * toilet.setName("Tandas Klia 1"); toilet.setImage(
 * "http://www.hawkrentacar.com.my/wp-content/uploads/2016/06/OneRepublic-in-Malaysia-Arrive-KLIA-from-Singapore-7824_0.jpg"
 * ); toilet.setLocation("KLIA Airport"); toilet.setPrice(5);
 * toilet.setUsed(75); toilet.setRating(4); toilet.setDuration(1); toilet.
 * setDescription("Toilet saya ini telah menjadi toilet kegemaran warga KL yang inginkan bersendiririan. Mereka boleh melayari internet secara percuma"
 * ); toilet.setToiletOwnerID(0); toiletRepository.save(toilet);
 * 
 * toilet1.setName("Tandas Klia 2"); toilet1.setImage(
 * "https://themangoroad.com/wp-content/uploads/2019/08/klia_2_01-1400x934.jpg")
 * ; toilet1.setLocation("KLIA 2 Airport"); toilet1.setPrice(10);
 * toilet1.setUsed(175); toilet1.setRating(4); toilet1.setDuration(1); toilet1.
 * setDescription("Toilet saya ini telah menjadi toilet kegemaran warga KLIA yang inginkan bersendiririan. Mereka boleh melayari internet secara percuma"
 * ); toilet1.setToiletOwnerID(0); toiletRepository.save(toilet1);
 * 
 * toilet2.setName("Tandas Klia 3"); toilet2.setImage(
 * "https://themangoroad.com/wp-content/uploads/2019/08/klia_2_01-1400x934.jpg")
 * ; toilet2.setLocation("KLIA 3 Airport"); toilet2.setPrice(20);
 * toilet2.setUsed(5); toilet2.setRating(2); toilet2.setDuration(1); toilet2.
 * setDescription("Toilet saya ini telah menjadi toilet kegemaran warga KLIA yang inginkan bersendiririan. Mereka boleh melayari internet secara percuma"
 * ); toilet2.setToiletOwnerID(0); toiletRepository.save(toilet1);
 * 
 * toiletUser.setName("Taka"); toiletUser.setImage(
 * "https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/f/0abaa395-c5bc-4c3c-b332-497a5e94d1fd/dd1ftdr-b55e63a8-9740-4f1e-9d33-c160057d1211.png?token=eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1cm46YXBwOiIsImlzcyI6InVybjphcHA6Iiwib2JqIjpbW3sicGF0aCI6IlwvZlwvMGFiYWEzOTUtYzViYy00YzNjLWIzMzItNDk3YTVlOTRkMWZkXC9kZDFmdGRyLWI1NWU2M2E4LTk3NDAtNGYxZS05ZDMzLWMxNjAwNTdkMTIxMS5wbmcifV1dLCJhdWQiOlsidXJuOnNlcnZpY2U6ZmlsZS5kb3dubG9hZCJdfQ.nKMSe7buspscV5aGotAMUhqmOm6nptmP17UyrVpiRn4"
 * ); toiletUser.setPassword("admin"); toiletUser.setPhoneNumber(0111111);
 * toiletUser.setEmail("admin@admin.com"); toiletUser.setWallet(50);
 * toiletUserRepository.save(toiletUser); }
 * 
 * 
 * }
 * 
 * 
 * }
 */