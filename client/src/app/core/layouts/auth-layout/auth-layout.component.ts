import { Component, Input } from "@angular/core";

@Component({
  selector: "app-auth-layout",
  imports: [],
  templateUrl: "./auth-layout.component.html",
})
export class AuthLayoutComponent {
  @Input() title!: string;
  @Input() description!: string;
}
