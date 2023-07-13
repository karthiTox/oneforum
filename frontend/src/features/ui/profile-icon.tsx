import { extractProfileText } from "../utils";

interface Props {
  username: string;
  size: string;
  fontSize: string;
  onClick?: () => any;
}

export function ProfileIcon({ username, size, fontSize, onClick }: Props) {
  return (
    <button
      className="btn btn-secondary rounded-circle p-0 m-0 d-flex justify-content-center align-items-center"
      style={{ width:size, height:size, fontSize }}
      onClick={onClick}
    >
      {extractProfileText(username ?? "Aa")}
    </button>
  );
}
