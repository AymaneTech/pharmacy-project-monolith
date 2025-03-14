import { Component, Input } from "@angular/core";
import { CommonModule } from "@angular/common";
import { FormControl, ReactiveFormsModule } from "@angular/forms";

@Component({
  selector: "app-form-field",
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: "./form-field.component.html",
})
export class FormFieldComponent {
  @Input() control!: FormControl;
  @Input() label = "";
  @Input() type = "text";
  @Input() id = "";
  @Input() placeholder = "";
  @Input() errors: { type: string; message: string }[] = [];
}
