import { Routes } from "@angular/router";
import { AuthLayoutComponent } from "./core/layouts/auth-layout/auth-layout.component";

export const routes: Routes = [
  {
    path: "auth",
    children: [
      {
        path: "signup",
        loadComponent: () =>
          import("./features/auth/pages/signup/signup.component").then(
            (m) => m.SignupComponent,
          ),
      },
    ],
  },
];
