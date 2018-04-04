package dhbw.leftlovers.service.chat.repository;

import dhbw.leftlovers.service.chat.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface OfferRepository extends JpaRepository<Offer, Long> {

    Optional<Offer> findByOfferId(Long offerId);
}
