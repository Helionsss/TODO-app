package com.samsung.todo.services;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.FirebaseDatabase;
import com.samsung.todo.models.User;

public class UserService {
    public static User createUser(AuthResult authResult) {
        return new User(
                "",
                authResult.getUser().getEmail(),
                authResult.getUser().getMetadata().getCreationTimestamp()
        );
    }

    public static void storeUser(User user) {
        FirebaseDatabase.getInstance("https://samsung-task-default-rtdb.europe-west1.firebasedatabase.app/")
                .getReference("users")
                .push()
                .setValue(user);
    }
}
