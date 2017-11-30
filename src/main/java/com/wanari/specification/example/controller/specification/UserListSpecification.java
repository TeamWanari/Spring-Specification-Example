package com.wanari.specification.example.controller.specification;

import com.wanari.specification.example.controller.dto.UserListRequest;
import com.wanari.specification.example.domain.Address;
import com.wanari.specification.example.domain.User;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.ListJoin;

import static org.springframework.data.jpa.domain.Specifications.where;

@Component
public class UserListSpecification extends BaseSpecification<User, UserListRequest> {

    @Override
    public Specification<User> getFilter(UserListRequest request) {
        return (root, query, cb) -> {
            query.distinct(true); //Important because of the join in the addressAttribute specifications
            return where(
                where(firstNameContains(request.search))
                    .or(lastNameContains(request.search))
                    .or(emailContains(request.search))
            )
                .and(streetContains(request.street))
                .and(cityContains(request.city))
                .toPredicate(root, query, cb);
        };

    }

    private Specification<User> firstNameContains(String firstName) {
        return userAttributeContains("firstName", firstName);
    }

    private Specification<User> lastNameContains(String lastName) {
        return userAttributeContains("lastName", lastName);
    }

    private Specification<User> emailContains(String email) {
        return userAttributeContains("email", email);
    }

    private Specification<User> userAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            return cb.like(
                cb.lower(root.get(attribute)),
                containsLowerCase(value)
            );
        };
    }

    private Specification<User> cityContains(String city) {
        return addressAttributeContains("city", city);
    }

    private Specification<User> streetContains(String street) {
        return addressAttributeContains("street", street);
    }

    private Specification<User> addressAttributeContains(String attribute, String value) {
        return (root, query, cb) -> {
            if(value == null) {
                return null;
            }

            ListJoin<User, Address> addresses = root.joinList("addresses", JoinType.INNER);

            return cb.like(
                cb.lower(addresses.get(attribute)),
                containsLowerCase(value)
            );
        };
    }
}
