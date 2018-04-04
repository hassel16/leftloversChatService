package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Offer;

import java.util.Optional;

public interface OfferService {

    Optional<Offer> findByOfferId(Long offerId);

    Offer getOffer(Long offerId);


}
