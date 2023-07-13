export type Props = {
  children: React.ReactNode;
  centerContent?: boolean;
  mdSize?: boolean
};

export function AppContainer({ children, centerContent, mdSize }: Props) {
  return (
    <div
      className={`container mb-5 px-4 ${
        centerContent && "d-flex justify-content-center"
      }`}

      style={{maxWidth:  "1050px"}}
    >
      {children}
    </div>
  );
}
