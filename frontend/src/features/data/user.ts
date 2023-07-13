import { UUID } from "./";

export interface User {
  uid: UUID,
  name: string,
  email: string,
  role: string
}
