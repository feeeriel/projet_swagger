package tn.esprit.Feryal_yahyaoui_4twin5.services;

import tn.esprit.Feryal_yahyaoui_4twin5.entities.Subscription;

import java.util.List;

public interface ISubscriptionServices {
    Subscription addSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    Subscription retrieveSubscription(Long numSub);
    List<Subscription> retrieveAll();
    void removeSubscription(long numSub);


}
