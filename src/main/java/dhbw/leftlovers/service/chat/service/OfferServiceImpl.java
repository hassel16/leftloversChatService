package dhbw.leftlovers.service.chat.service;

import dhbw.leftlovers.service.chat.entity.Offer;
import dhbw.leftlovers.service.chat.exception.OfferNotFoundException;
import dhbw.leftlovers.service.chat.repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OfferServiceImpl implements OfferService {

    private OfferRepository offerRepository;

    @Autowired
    public OfferServiceImpl(OfferRepository offerRepository) {
        this.offerRepository = offerRepository;
    }

    @Override
    public Optional<Offer> findByOfferId(Long offerId) {
        return offerRepository.findByOfferId(offerId);
    }

    @Override
    public Offer getOffer(Long offerId) {
        return this.findByOfferId(offerId).orElseThrow(() -> new OfferNotFoundException(offerId));
    }


}
