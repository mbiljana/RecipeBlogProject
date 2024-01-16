package rs.ac.uns.acs.smpuos.AuthService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import rs.ac.uns.acs.smpuos.AuthService.model.Image;

@Repository
public interface ImageRepository extends MongoRepository<Image, Long> {
}
